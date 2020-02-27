package string;

public class MinNumberOfOpRequiredToGetOriginalString {

    public static int getNumberOfOp(String str, int n1, int n2){
        int count =0;
        String temp="";
        String orignalstr=str;
        int arr[]={n1,n2};
        while(!orignalstr.equalsIgnoreCase(temp)){
            for(int i =0; i <arr.length;i++){
                String substr= str.substring(str.length()-arr[i]);
                temp=substr+temp;
                str=substr+str.substring(0,str.length()-arr[i]);
                count++;
            }

        }


        return  count;

    }

    public static void main(String[] args) {
        System.out.println(getNumberOfOp("AbcDef",1,2));
    }

}
