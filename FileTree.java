import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class FileTree {
    private static OutputStream outputStream =System.out;
    public static final int span=3;

    private static void printDirTree_(File dir,int depth,String startStr,List<Integer> parentDepths){
        for(int i=0;i<depth;i++){
            if(parentDepths.contains(i))
                System.out.print("│");
            System.out.print(" ");

        }

        System.out.print(startStr);
        System.out.println(dir.getName());

        File[] files=dir.listFiles();
        List<File> fileList=new ArrayList<>();
        for(File file:files){
            if(file.isDirectory())
                fileList.add(file);
        }

        for(int i=0;i<fileList.size();i++){
            int currentSize=parentDepths.size();
            if(i!=fileList.size()-1){
                startStr="├─";
                parentDepths.add(depth+2);
            }
            else{
                startStr="└─";
            }
            printDirTree_(fileList.get(i),depth+2,startStr,parentDepths);

            while(parentDepths.size()>currentSize){
                parentDepths.remove(currentSize);
            }
        }
    }

    public static void printDirTree(String dirName){
        printDirTree_(new File(dirName), 0, "├─", new ArrayList<>());
    }
    private static void printFileTree_(File file,int depth,String startStr,List<Integer> parentDepths){
        for(int i=0;i<depth;i++){
            if(parentDepths.contains(i))
                System.out.print("│");
            System.out.print(" ");

        }

        System.out.print(startStr);
        System.out.println(file.getName());

        if(!file.isDirectory())
            return;


        File[] files=file.listFiles();

        for(int i=0;i<files.length;i++){
            int currentSize=parentDepths.size();
            if(i!=files.length-1){
                startStr="├─";
                parentDepths.add(depth+span);
            }
            else{
                startStr="└─";
            }
            printFileTree_(files[i],depth+span,startStr,parentDepths);

            while(parentDepths.size()>currentSize){
                parentDepths.remove(currentSize);
            }
        }
    }


    public static void printFileTree(String fileName){
        printFileTree_(new File(fileName), 0, "├─", new ArrayList<>());
    }


    public static void printFileTree2File(String dirName,String outputFileName){
        StringBuilder builder=new StringBuilder();
        printFileTree2File_(builder,new File(dirName),0,"├-",new ArrayList<>());
        printContentToFile(builder,outputFileName);
    }

    public static void printDirTree2File(String fileName,String outputFileName){
        StringBuilder builder=new StringBuilder();
        printDirTree2File_(builder,new File(fileName),0,"├-",new ArrayList<>());
        printContentToFile(builder,outputFileName);
    }


    private static void printDirTree2File_(StringBuilder builder,File dir,int depth,String startStr,List<Integer> parentDepths){
        for(int i=0;i<depth;i++){
            if(parentDepths.contains(i))
                builder.append('│');
            builder.append(" ");

        }

        builder.append(startStr);
        builder.append(dir.getName()+"\r\n");

        File[] files=dir.listFiles();
        List<File> fileList=new ArrayList<>();
        for(File file:files){
            if(file.isDirectory())
                fileList.add(file);
        }

        for(int i=0;i<fileList.size();i++){
            int currentSize=parentDepths.size();
            if(i!=fileList.size()-1){


/**
 * Created by asus on 2017/3/17.
 */
                startStr="├─";
                parentDepths.add(depth+span);
            }
            else{
                startStr="└─";
            }
            printDirTree2File_(builder,fileList.get(i),depth+span,startStr,parentDepths);//startStr.length()==2,show 1 token's position later.

            while(parentDepths.size()>currentSize){
                parentDepths.remove(currentSize);
            }
        }
    }

    private static void printFileTree2File_(StringBuilder builder,File file,int depth,String startStr,List<Integer> parentDepths){
        for(int i=0;i<depth;i++){
            if(parentDepths.contains(i))
                builder.append('│');
            builder.append(" ");
        }

        builder.append(startStr);
        builder.append(file.getName()+"\r\n");

        if(!file.isDirectory())
            return;


        File[] files=file.listFiles();

        for(int i=0;i<files.length;i++){
            int currentSize=parentDepths.size();
            if(i!=files.length-1){
                startStr="├─";
                parentDepths.add(depth+span);
            }
            else{
                startStr="└─";
            }
            printFileTree2File_(builder,files[i],depth+span,startStr,parentDepths);

            while(parentDepths.size()>currentSize){
                parentDepths.remove(currentSize);
            }
        }
    }

    private static void printContentToFile(StringBuilder builder,String outputFileName){
        try {
            outputStream=new FileOutputStream(new File(outputFileName));
            FileChannel fileChannel=((FileOutputStream)outputStream).getChannel();
            String content=builder.toString();
            ByteBuffer buffer=ByteBuffer.wrap(content.getBytes());
            fileChannel.write(buffer);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args){
        if(args.length<2){
            System.out.println("-v/V ------------print in the screen ");
            System.out.println("-d/D ------------print only dirs in the outcome.");
            System.out.println("-f/F ------------print all files(include dirs) in the outcome.");
            System.out.println("example> -vd [dirName] to print the dirs and subDirs in this dir");
            return;
        }
        String ops=args[0];
        String fileName=args[1];
        if(ops.contains("v")||ops.contains("V")){
            if(ops.contains("d")||ops.contains("D")){
                printDirTree(fileName);
            }else{
                printFileTree(fileName);
            }
        }else{
            if(args.length!=3){
                System.err.println("There is no output file,bye...");
            }
            String outputFile=args[2];

            if(ops.contains("d")||ops.contains("D")){
                printDirTree2File(fileName,outputFile);
            }else{
                printFileTree2File(fileName,outputFile);
            }
        }
    }

}
