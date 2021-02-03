package com.hao.process;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <code>Solution_70</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/5/3
 * @version: 1.0
 */
public class Demo1 {
    public void testProcess() throws IOException,InterruptedException{

        Process process = Runtime.getRuntime().exec("ls -la");
        InputStream inputStream = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while((line = br.readLine()) != null){
            System.out.println("line:"+line);
        }
        inputStream.close();
        br.close();
        int exitCode = process.waitFor();
        System.out.println("exitCode:"+exitCode);
    }

    public void testProcessBuilder() throws IOException,InterruptedException{
        List<String> params = new ArrayList<>();
        params.add("ls");
        params.add("-la");
        ProcessBuilder builder = new ProcessBuilder(params);
        builder.redirectErrorStream(true);
        Process process = builder.start();
        InputStream inputStream = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while((line = br.readLine()) != null){
            System.out.println("line:"+line);
        }
        inputStream.close();
        br.close();
        int exitCode = process.waitFor();
        System.out.println("exitCode:"+exitCode);

    }

    public void testProcessBuilder1() throws IOException,InterruptedException{
        File file1 = new File("/Users/haoxueqiang/test/test1");
        File file2 = new File("/Users/haoxueqiang/test/test2");
        if(!file2.exists()){
            file2.mkdirs();
        }

        for(File file: file1.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if(pathname.getName().indexOf(".txt") >= 0){
                    return true;
                }else{
                    return false;
                }
            }
        })){


            //调用split分割文件
            List<String> commands = new ArrayList<String>();
            commands.add("split");
            //Add arguments
            commands.add("-C");
            commands.add(50000000+"");
            commands.add("-d");
            commands.add("-a");
            commands.add("5");
            String suffixName = "--additional-suffix=."+file.getName();
            commands.add(suffixName);
            commands.add(file.getAbsolutePath());
            commands.add(file2.getAbsolutePath());
            System.out.println(commands);
            ProcessBuilder pb = new ProcessBuilder(commands);
//                pb.directory(outPutFile);
            pb.redirectErrorStream(true);
            Process process = pb.start();
            StringBuilder out = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null, previous = null;
            while ((line = br.readLine()) != null) {
                if (!line.equals(previous)) {
                    previous = line;
                    out.append(line).append(" ");
                    System.out.println(out.toString());
                }
            }
            if (process.waitFor() == 0) {
                System.out.println("success");
            } else {
                System.out.println("fail");
            }
        }

    }

    public static void main(String[] args) throws Exception {
        Demo1 demo = new Demo1();
        demo.testProcessBuilder1();
    }
}
