package resource;

public class vLink implements Comparable<vLink>{

    int s;
    int e;
    double bandwith;

    public vLink(int s, int e, double bandwith) {
        this.s = s;
        this.e = e;
        this.bandwith = bandwith;
    }

    public vLink() {

    }

    @Override
    public int compareTo(vLink o) {

        if(o.bandwith>this.bandwith){
            return 1;

        }else if(o.bandwith<this.bandwith){
            return -1;
        }else{
            return 0;
        }
    }


    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public double getBandwith() {
        return bandwith;
    }

    public void setBandwith(double bandwith) {
        this.bandwith = bandwith;
    }




}
