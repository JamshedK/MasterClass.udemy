package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        System.out.println(getBucketCount(3.4, 2.1, 1.5 ,2));
        System.out.println(getBucketCount(3.26, 0.75));
    }
    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets ){
        if(width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0){
            return -1;
        }
        double remainingArea = (width * height) - extraBuckets * areaPerBucket;
        return (int) Math.ceil(remainingArea/areaPerBucket);

    }
    public static int getBucketCount(double width, double height, double areaPerBucket){
        if(width <= 0 || height <= 0 || areaPerBucket <= 0 ){
            return -1;
        }
        double area = (width * height);
        return (int) Math.ceil(area/areaPerBucket);
    }
    public static int getBucketCount(double area,  double areaPerBucket){
        if( areaPerBucket <= 0 || area <= 0){
            return -1;
        }
        return (int) Math.ceil(area/areaPerBucket);
    }
}
