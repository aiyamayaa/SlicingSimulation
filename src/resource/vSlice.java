package resource;

import java.util.ArrayList;
import java.util.List;

public class vSlice {
    List<Integer> aauSet;
    List<vLink> adlinks;

    List<vLink> dclinks;

    public vSlice(List<vLink> adlinks, List<Integer> aauSet, List<vLink> dclinks) {
        this.adlinks = adlinks;
        this.aauSet = aauSet;
        this.dclinks = dclinks;
    }

    public vSlice() {
    }

    public vSlice(List<vLink> adlinks, List<Integer> aauSet) {
        this.adlinks = adlinks;
        this.aauSet = aauSet;
    }

    public vSlice(String aauSet,String[] links) {
        String[] aaus = aauSet.split(" ");
        List<Integer> aaulist = new ArrayList<>();
        for(String s:aaus){
            aaulist.add(Integer.parseInt(s));
        }
        this.aauSet = aaulist;
        int n = getAauNums();
        List<vLink> adlink = new ArrayList<>();
        List<vLink> dclink = new ArrayList<>();
        for(int i=0;i<n;i++){
            String s = links[i];
            String[] li = s.split(" ");
            adlink.add(new vLink(Integer.parseInt(li[0]),Integer.parseInt(li[1]),Double.parseDouble(li[2])));
        }
        for(int i=n;i<links.length;i++){
            String s = links[i];
            String[] li = s.split(" ");
            dclink.add(new vLink(Integer.parseInt(li[0]),Integer.parseInt(li[1]),Double.parseDouble(li[2])));
        }
        this.adlinks = adlink;
        this.dclinks = dclink;
    }

    public int getAauNums(){
        return aauSet.size();
    }

    public List<Integer> getAauSet() {
        return aauSet;
    }

    public void setAauSet(List<Integer> aauSet) {
        this.aauSet = aauSet;
    }

    public List<vLink> getAdlinks() {
        return adlinks;
    }

    public void setAdlinks(List<vLink> adlinks) {
        this.adlinks = adlinks;
    }

    public List<vLink> getDclinks() {
        return dclinks;
    }

    public void setDclinks(List<vLink> dclinks) {
        this.dclinks = dclinks;
    }
}
