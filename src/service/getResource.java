package service;

import bin.EdgeWeightedDigraph;
import bin.In;
import resource.vSlice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class getResource {
    /**
     * 获取切片请求,每一行一个切片请求，返回值为切片的集合
     *
     * */
    Scanner scanner;

    public List<vSlice> getSliceRequest(String sliceFile){
        List<vSlice> slices = new ArrayList<>();
        File file = new File(sliceFile);
        if(file.isFile()&&file.exists()) {
          //  System.out.println("not null");
            BufferedReader infile;
            try {
                infile = new BufferedReader(new FileReader(file));
                String s = "";
                int i=0;

                while (( s=infile.readLine())!=null) {
                    String[] res =s.split("#");
                    String aauset = res[0];
                    String[] linkset = res[1].split("&");
                    System.out.println(s);
                    vSlice slice = new vSlice(aauset,linkset);
                    slices.add(slice);
                }

            } catch ( IOException e) {
                System.out.print("error");
                e.printStackTrace();
            }
        }
        return slices;
    }

    public static EdgeWeightedDigraph getGraph(String file){
        In in = new In(file);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        return G;
    }

    public static void main(String[] args){
        String filename = "E:\\gitaiyamayaa\\SlicingSimulation\\src\\data\\sliceRequest.txt";
       // String filename2 = "E:/gitaiyamayaa/SlicingSimulation/src/resource/vSlice.txt";
        getResource gr = new getResource();
        gr.getSliceRequest(filename);
    }
}
