import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        List<String> text = new ArrayList<>();
        for(String temp : str.split(" ")){
            text.add(temp);
        }

        for(int i = 0;i < text.size() - 1;++i){
            String max = text.get(i);
            int maxind = i;
            for(int j = i+1;j < text.size();++j){
                if(text.get(j).length() > max.length()){
                    max = text.get(j);
                    maxind = j;
                }
            }
            if( maxind != i) {
                String temp = text.get(i);
                text.set(i, max);
                text.set(maxind, temp);
            }
        }

        for(int i = 0;i < text.size();++i){
            int j = i+1;
            int k = 0;
            while(j < text.size() && text.get(i).length() == text.get(j).length()){
                ++j;
                ++k;
            }
            if(k!=0) {
                for (int i1 = i; i1 < j; ++i1) {
                    String min = text.get(i1);
                    int minind = i1;
                    for (int s = i1 + 1; s < j - 1; ++s) {
                        int counter1 = 0;
                        int counter2 = 0;
                        for (int s1 = 0; s1 < min.length(); ++s1) {
                            char c1 = min.charAt(s1);
                            char c2 = text.get(s).charAt(s1);
                            if(c1 == 'y' || c1 == 'u' || c1 == 'i' || c1 == 'e' || c1 == 'o' || c1 == 'a'){
                                ++counter1;
                            }
                            if(c2 == 'y' || c2 == 'u' || c2 == 'i' || c2 == 'e' || c2 == 'o' || c2 == 'a'){
                                ++counter2;
                            }
                        }
                        if(counter2 < counter1){
                            min = text.get(s);
                            minind = s;
                        }
                    }
                    if(minind != i1){
                        String temp = text.get(i1);
                        text.set(i1, min);
                        text.set(minind, temp);
                    }
                }
                i = i + k - 1;
            }
        }

       for(String temp : text){
           System.out.println(temp);
       }

    }
}
