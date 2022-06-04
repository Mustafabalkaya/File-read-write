package algoritma_final;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Mustafa Balkaya
 */
public class Mustafa_Balkaya 
{

    public static void main(String[] args) 
    {
        int dizi1[] = {54,25,33,4,-57,13,42};
        int dizi2[] = {45,65,78,1,34,-2,75,54};
        int[] dizi3 = new int[dizi1.length + dizi2.length];
          //KULLANDIĞIM METOTLAR 
        dosyayiOku();
        siralamaYap(dizi1,dizi2);//KABARCIK SIRALAMASI KULLANILDI 
        dizileriBirlestir(dizi1,dizi2,dizi3);
        dosyayiYaz(dizi3);
        aramaYap(dizi3);
 
    }
    private static void dosyayiOku() 
    {
        
        try{
        String okunan=null;
        File dosya=new File ("diziler.txt");
        Scanner okuyucu =new Scanner(dosya);
        while(okuyucu.hasNextLine())  
        {
        okunan=okuyucu.nextLine();
        System.out.println(""+okunan);
        }
        }catch (FileNotFoundException e)
        {
        System.out.println("böyle bir txt belgesi bulunmamaktadır");
        
        }
        
    }
    public static void siralamaYap(int []A,int []B)//KABARCIK SIRALAMASI YAPILDI
    {
        
        int gecici;
        
        System.out.println("SIRALANMIŞ DİZİ 1");
        for(int i=0; i<A.length; i++)
        {

        for(int j=A.length-1 ; j>i;j--) 
        {
        if(A[j-1]>A[j])
        {
          gecici=A[j-1];
          A[j-1]=A[j];
          A[j]=gecici;
        }
        }
      
        System.out.println(A[i]);
        
        }
        int gecici1;
        
        System.out.println("SIRALANMIŞ DİZİ 2");
        for(int i=0; i<B.length; i++)
        {

        for(int j=B.length-1 ; j>i;j--) 
        {
        if(B[j-1]>B[j])
        {
          gecici1=B[j-1];
          B[j-1]=B[j];
          B[j]=gecici1;
        }
        }
      
        System.out.println(B[i]);
       
        }
    
    }
    public static int[] dizileriBirlestir(int []a,int[]b,int []c)
    {
        int z, x, y = 0;
    for (z = 0; z < a.length; z++) 
    {
        
        for (y = z; y < a.length; y++) 
        {
            c[y] = a[z];
        }
    }
    for (x = 0; x < b.length; x++) {
        
        for (y = a.length + x; y < c.length; y++)
        {
            c[y] = b[x];
        }
    }
        int gecici2;
        
        System.out.println("Dizi3 ");
        for(int i=0; i<c.length; i++)
        {

        for(int j=c.length-1 ; j>i;j--) 
        {
        if(c[j-1]>c[j])
         {
          gecici2=c[j-1];
          c[j-1]=c[j];
          c[j]=gecici2;
         }
        }
      
        System.out.println(c[i]);
        }
        return c;
        
    }
    public static int[] dosyayiYaz(int []c) 
    {
        
        File dosya = new File("siralanmisDiziler.txt");
        try
        {
            FileWriter yazici = new FileWriter(dosya);
        yazici.write("Dizi3 \n");
        for (int i = 0; i < c.length; i++) 
        {
        yazici.write(String.valueOf(c[i])+" \n ");
        }
        yazici.close();
        } catch (IOException e) 
        {
            
         System.out.println("Bir Hata İle Karşılaşıldı...");
         
   
        }
     
    return c;
    }


   
    public static int[] aramaYap (int []c)
    {
        try {
        Scanner in=new Scanner (System.in);
        while(true)
        {
        int kontrol=0;
        System.out.println("Aranılacak Sayıyı Giriniz...");
        int aranan=in.nextInt();
        for (int i = 0; i < c.length; i++) 
        {
        if (c[i]==aranan) 
        {
        System.out.println("Aradığınız Sayı Dosyada "+(i+1)+".Satırda Bulunmaktadır");
        kontrol=1;
                    

        }
        }
        if (kontrol==0) 
        {
        System.out.println("Aradığınız sayı bulunmadı ");
        
        }
        }
        }catch(Exception e){
            System.out.println("Program sonlandırıldı");
            
        }
        
        return c;
    }
    
}
