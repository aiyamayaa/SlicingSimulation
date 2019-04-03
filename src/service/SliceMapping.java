package service;

import bin.*;
import resource.vLink;
import resource.vSlice;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * 切片映射
 * */
public class SliceMapping {

    /**
     * 计算前传链路的映射：AAU到
     * 输入:aauId,aau-du带宽,aau-du路径带宽，du资源
     * */
    public List<Integer> fronthHaulMapping(List<Integer> aauSet, List<vLink> linkRes, List<Integer> duResource,
                                           EdgeWeightedDigraph graph){
        List<Integer> res = new ArrayList<>();
        //虚拟链路按照带宽进行排序
        PriorityQueue<vLink> links = new PriorityQueue();
        for(vLink l:linkRes){
            links.add(l);
        }
        System.out.println(links.size());
//        for(int i=0;i<3;i++){
//            vLink l = links.poll();
//            System.out.println(l.getBandwith());
//        }
        //执行映射
        while (!links.isEmpty()){
            vLink vlink = links.poll();
            if(aauSet.contains( vlink.getS())){
                DijkstraSP sp = new DijkstraSP(graph,vlink.getS());
                //到其他所有点的路径
                for (int t = 0; t < graph.V(); t++) {
                    if (sp.hasPathTo(t)) {
                        StdOut.printf("%d to %d (%.2f)  ", vlink.getS(), t, sp.distTo(t));
                        for (DirectedEdge e : sp.pathTo(t)) {
                            StdOut.print(e + "   ");
                        }
                        StdOut.println();
                    }
                    else {
                        StdOut.printf("%d to %d         no path\n", vlink.getS(), t);
                    }
                }
            }else{
                System.out.println("error!! no such aau of link");
            }

        }
        return res;
    }


    public static void main(String[] args){
        String filename = "E:\\gitaiyamayaa\\SlicingSimulation\\src\\data\\sliceRequest.txt";
        // String filename2 = "E:/gitaiyamayaa/SlicingSimulation/src/resource/vSlice.txt";
        getResource gr = new getResource();
        List<vSlice> vslices = gr.getSliceRequest(filename);
        vSlice slice = vslices.get(0);
        SliceMapping sliceMapping = new SliceMapping();
        sliceMapping.fronthHaulMapping(null,slice.getAdlinks(),null,null);
    }

    public static vLink[] toArray(List<vLink> links){
        vLink[] link = new vLink[links.size()];
        for (int i=0;i<links.size();i++) {
            link[i] = links.get(i);
        }
        return link;
    }
}
