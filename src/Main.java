import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 示例用法
        String sourceDir = "/Volumes/三星T7/02-学习宝库/技能证书考试/系统架构设计师/01-培训资料1"; // 替换为您的源目录
        String targetDir = "/Users/liuxin/Desktop/软考资料整合"; // 替换为目标目录
        searchAndDownloadPdfFile(sourceDir, targetDir);
    }

    private static void searchAndDownloadPdfFile(String sourceFilePath, String targetFilePath) {
        // 1. 搜索所有PDF文件
        List<File> pdfFiles = findPDFFiles(sourceFilePath);

        // 2. 创建目标目录(如果不存在)
        createTargetDirectory(targetFilePath);

        // 3. 复制所有PDF文件到目标目录
        for (File pdfFile : pdfFiles) {
            copyFile(pdfFile, targetFilePath);
        }

        System.out.println("共找到并复制 " + pdfFiles.size() + " 个PDF文件到目标目录");
    }

    /**
     * 递归查找指定目录下的所有PDF文件
     */
    private static List<File> findPDFFiles(String directoryPath) {
        List<File> pdfFiles = new ArrayList<>();
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.err.println("提供的路径不存在或不是目录: " + directoryPath);
            return pdfFiles;
        }

        findPDFFilesInDirectory(directory, pdfFiles);
        return pdfFiles;
    }

    /**
     * 递归辅助方法，查找PDF文件
     */
    private static void findPDFFilesInDirectory(File directory, List<File> pdfFiles) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    findPDFFilesInDirectory(file, pdfFiles); // 递归调用
                } else if (isPDFFile(file)) {
                    pdfFiles.add(file);
                }
            }
        }
    }

    /**
     * 检查文件是否是PDF文件
     */
    private static boolean isPDFFile(File file) {
        String fileName = file.getName().toLowerCase();
        return fileName.endsWith(".pdf");
    }

    /**
     * 创建目标目录(如果不存在)
     */
    private static void createTargetDirectory(String targetPath) {
        Path path = Paths.get(targetPath);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
                System.out.println("已创建目标目录: " + targetPath);
            } catch (IOException e) {
                System.err.println("无法创建目标目录: " + e.getMessage());
            }
        }
    }

    /**
     * 复制文件到目标目录
     */
    private static void copyFile(File sourceFile, String targetDir) {
        String targetPath = targetDir + File.separator + sourceFile.getName();
        File targetFile = new File(targetPath);

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(targetFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("已复制: " + sourceFile.getAbsolutePath() + " -> " + targetPath);
        } catch (IOException e) {
            System.err.println("复制文件失败: " + sourceFile.getAbsolutePath() + " - " + e.getMessage());
        }
    }
}
