package leetcode.设计.布隆过滤器;

import java.util.BitSet;
import java.util.Random;

public class BloomFilter {
    private BitSet bitSet;          // 位数组
    private int size;               // 位数组大小
    private int hashFunctionsCount; // 哈希函数数量
    private int[] seeds;            // 哈希函数种子

    /**
     * 构造布隆过滤器
     * @param expectedElements 预期元素数量
     * @param falsePositiveRate 期望的误判率（0.0-1.0）
     */
    public BloomFilter(int expectedElements, double falsePositiveRate) {
        // 计算最优的位数组大小
        this.size = calculateOptimalSize(expectedElements, falsePositiveRate);
        // 计算最优的哈希函数数量
        this.hashFunctionsCount = calculateOptimalHashFunctions(expectedElements, size);
        // 初始化位数组
        this.bitSet = new BitSet(size);
        // 生成哈希函数种子
        this.seeds = generateSeeds(hashFunctionsCount);
    }

    /**
     * 计算最优的位数组大小
     */
    private int calculateOptimalSize(int n, double p) {
        // 公式: m = - (n * ln(p)) / (ln(2)^2)
        return (int) Math.ceil(-(n * Math.log(p)) / (Math.log(2) * Math.log(2)));
    }

    /**
     * 计算最优的哈希函数数量
     */
    private int calculateOptimalHashFunctions(int n, int m) {
        // 公式: k = (m/n) * ln(2)
        return Math.max(1, (int) Math.round((double) m / n * Math.log(2)));
    }

    /**
     * 生成哈希函数种子
     */
    private int[] generateSeeds(int count) {
        int[] seeds = new int[count];
        Random random = new Random(42); // 固定种子以保证可重复性
        for (int i = 0; i < count; i++) {
            seeds[i] = random.nextInt();
        }
        return seeds;
    }

    /**
     * 添加元素到布隆过滤器
     */
    public void add(String key) {
        for (int i = 0; i < hashFunctionsCount; i++) {
            int hash = hash(key, seeds[i]);
            int position = Math.abs(hash % size);
            bitSet.set(position, true);
        }
    }

    /**
     * 检查元素是否可能存在（可能有误判）
     */
    public boolean contains(String key) {
        for (int i = 0; i < hashFunctionsCount; i++) {
            int hash = hash(key, seeds[i]);
            int position = Math.abs(hash % size);
            if (!bitSet.get(position)) {
                return false; // 如果任一位为0，则肯定不存在
            }
        }
        return true; // 所有位都为1，则可能存在
    }

    /**
     * 哈希函数实现（基于字符串哈希）
     */
    private int hash(String key, int seed) {
        int hashCode = seed;
        for (int i = 0; i < key.length(); i++) {
            hashCode = seed * hashCode + key.charAt(i);
        }
        return hashCode;
    }

    /**
     * 获取布隆过滤器的统计信息
     */
    public void printStats(int insertedElements) {
        System.out.println("布隆过滤器统计信息:");
        System.out.println("位数组大小: " + size + " bits");
        System.out.println("哈希函数数量: " + hashFunctionsCount);
        System.out.println("插入元素数量: " + insertedElements);

        // 计算理论误判率
        double falsePositiveRate = Math.pow(1 - Math.exp(-hashFunctionsCount * insertedElements / (double) size), hashFunctionsCount);
        System.out.println("理论误判率: " + String.format("%.6f", falsePositiveRate * 100) + "%");

        // 计算实际使用率
        int setBits = bitSet.cardinality();
        double usage = (double) setBits / size * 100;
        System.out.println("位数组使用率: " + String.format("%.2f", usage) + "%");
    }

    /**
     * 测试示例
     */
    public static void main(String[] args) {
        // 创建布隆过滤器：预期10000个元素，误判率1%
        BloomFilter bloomFilter = new BloomFilter(10000, 0.9);

        // 添加一些元素
        String[] testWords = {"apple", "banana", "orange", "grape", "watermelon",
                             "pineapple", "strawberry", "blueberry", "peach", "cherry"};

        for (String word : testWords) {
            bloomFilter.add(word);
        }

        // 测试存在的元素
        System.out.println("测试存在的元素:");
        for (String word : testWords) {
            boolean exists = bloomFilter.contains(word);
            System.out.println(word + ": " + exists + " (应为true)");
        }

        // 测试不存在的元素（可能会有误判）
        System.out.println("\n测试不存在的元素:");
        String[] nonExistentWords = {"mango", "kiwi", "papaya", "dragonfruit", "lychee"};
        for (String word : nonExistentWords) {
            boolean exists = bloomFilter.contains(word);
            System.out.println(word + ": " + exists + " (应为false)");
        }

        // 打印统计信息
        System.out.println();
        bloomFilter.printStats(testWords.length);
    }
}
