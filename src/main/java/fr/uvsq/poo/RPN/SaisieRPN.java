package fr.uvsq.poo.RPN;


import java.util.Scanner;

public class SaisieRPN {
    MoteurRPN rpn;
    Scanner scan = new Scanner(System.in);
    Invoker in;

    public SaisieRPN(Invoker in,MoteurRPN rpn){
        this.rpn = rpn;
        this.in = in;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }


    public boolean read(){
        String str = new String(" ");
       while(!str.equals("")){
                str = scan.nextLine();
                if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") )
                {
                    in.modify("apOP",str,in.get("apOP"));
                    in.execute("apOP");
                    //in.execute("retOP");
                }
                else if(SaisieRPN.isNumeric(str))
                {
                    //System.out.print(str);
                    in.modify("regOP",str,in.get("regOP"));
                    in.execute("regOP");
                    //in.execute("retOP");


                }else{
                    if(str.equals("undo")){
                    //in.execute("retOP");
                    in.execute("undo");
                    //rpn.regOPUndo();
                    //in.execute("retOP");
                    }else if(str.equals("exit")){
                        in.execute("retOP");
                        in.execute("exit");
                    }else if(str.equals("print")){
                        in.execute("retOP");
                    }
                    else {
                   System.out.println("Not a number nor operator");
                    }
           }
                str.replace(str," ");
       }
       return true;
    }


}
