package org.example.analyzer;

public class MethodUsageInfo {

    private String definedFile;
    private int usageCount;

    public MethodUsageInfo(String definedFile) {
        this.definedFile = definedFile;
        this.usageCount = 0;
    }

    public void incrementUsage() {
        this.usageCount++;
    }

    public String getDefinedFile() {
        return definedFile;
    }

    public int getUsageCount() {
        return usageCount;
    }
}