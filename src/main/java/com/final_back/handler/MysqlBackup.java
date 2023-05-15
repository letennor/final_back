package com.final_back.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MysqlBackup {

    /**
     * 备份数据库
     * @return
     */
    public void restoreMysql() {
        try {
            StringBuffer sb = new StringBuffer();
            sb.append("mysqldump");
            sb.append(" -h127.0.0.1");
            sb.append(" -u" + "root");
            sb.append(" -p" + "root");
            sb.append(" " + "huang_final" + " >");
            sb.append("D:/MySQLResource/huang_final2.sql");
            System.out.println("cmd命令为：" + sb.toString());
            Runtime runtime = Runtime.getRuntime();
            System.out.println("开始备份：" + "huang_final");
            Process process = runtime.exec("cmd /c" + sb.toString());

            if (process.waitFor() == 0) {
                System.out.println("备份成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("备份失败");
        }

    }

    public void recoverMysql() {
        StringBuilder sb = new StringBuilder();
        sb.append("mysql");
        sb.append(" -h127.0.0.1");
        sb.append(" -u" + "root");
        sb.append(" -p" + "root");
        sb.append(" " + "huang_final_backup" + " <");
        sb.append("D:/MySQLResource/huang_final2.sql");
        System.out.println("cmd命令为：" + sb.toString());
        Runtime runtime = Runtime.getRuntime();
        System.out.println("开始还原数据");
        try {
            Process process = runtime.exec("cmd /c" + sb.toString());
            InputStream is = process.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is, "utf8"));
            String line = null;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }
            is.close();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("还原成功！");
    }

    public void restoreMysqlLinux() {
        try {
            StringBuffer sb = new StringBuffer();
            sb.append("mysqldump");
            sb.append(" -h110.40.209.66");
            sb.append(" -u" + "root");
            sb.append(" -p" + "abc123...");
            sb.append(" " + "huang_final" + " >");
            sb.append("/root/mysqlBackupTest/huang_final2.sql");
            System.out.println("cmd命令为：" + sb.toString());
            Runtime runtime = Runtime.getRuntime();
            System.out.println("开始备份：" + "huang_final");

            String[] command = {"/bin/sh", "-c", sb.toString()};

            Process process = Runtime.getRuntime().exec(command);

            System.out.println(process);
            if (process.waitFor() == 0) {
                System.out.println("备份成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("备份失败");
        }
    }


}
