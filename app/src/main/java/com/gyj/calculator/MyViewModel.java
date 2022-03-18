package com.gyj.calculator;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//存储数据模型
public class MyViewModel extends ViewModel {
    private MutableLiveData<String> Mainnum;
    public String sign1="",sign2="";//存运算符号
    public String num[]={"",""};//存储运算数字
    public boolean havepoint = false;//有咩有小数点

    public MutableLiveData<String> getMainnum() {
        if (Mainnum == null) {
            Mainnum = new MutableLiveData<>();
            Mainnum.setValue("0");
        }
        return Mainnum;
    }

    public void setMainnum(String n) {
        if (Mainnum.getValue().equals("0")) {
            Mainnum.setValue(n);
        } else {
            Mainnum.setValue(Mainnum.getValue() + n);
        }
    }
    public String mianNumWithnum0(){
        String value ="0";
        if(Mainnum.getValue().contains(".")||num[0].contains(".")){
            switch (sign1){
                case "+" :
                    value = String.valueOf(Double.valueOf(num[0])+Double.valueOf(Mainnum.getValue()));
                    break;
                case "-" :
                    value = String.valueOf(Double.valueOf(num[0])-Double.valueOf(Mainnum.getValue()));
                    break;
                case "*" :
                    value = String.valueOf(Double.valueOf(num[0])*Double.valueOf(Mainnum.getValue()));
                    break;
                case "/" :
                    if(Mainnum.getValue().equals("0"))
                        Mainnum.setValue("1");
                    value = String.valueOf(Double.valueOf(num[0])/Double.valueOf(Mainnum.getValue()));
                    break;
            }
        }else {//如果两个数都是整数
            switch (sign1){
                case "+":
                    value = String.valueOf(Integer.parseInt(num[0])+Integer.parseInt(Mainnum.getValue()));
                    break;
                case "-":
                    value = String.valueOf(Integer.parseInt(num[0])-Integer.parseInt(Mainnum.getValue()));
                    break;
                case "*":
                    value = String.valueOf(Integer.parseInt(num[0])*Integer.parseInt(Mainnum.getValue()));
                    break;
                case "/":
                    if(Mainnum.getValue().equals("0"))
                        Mainnum.setValue("1");
                    value = String.valueOf(Double.valueOf(num[0])/Double.valueOf(Mainnum.getValue()));
                    break;
            }

        }

        return value;
    }

public String mianNumWithnum1(){
    String value ="0";
    if(Mainnum.getValue().contains(".")||num[0].contains(".")){
        switch (sign2){
                case "*" :
                value = String.valueOf(Double.valueOf(num[1])*Double.valueOf(Mainnum.getValue()));
                break;
            case "/" :
                if(Mainnum.getValue().equals("0"))
                    Mainnum.setValue("1");
                value = String.valueOf(Double.valueOf(num[1])/Double.valueOf(Mainnum.getValue()));
                break;
        }
    }else {//如果两个数都是整数
        switch (sign2){
            case "*":
                value = String.valueOf(Integer.parseInt(num[1])*Integer.parseInt(Mainnum.getValue()));
                break;
            case "/":
                if(Mainnum.getValue().equals("0"))
                    Mainnum.setValue("1");
                value = String.valueOf(Double.valueOf(num[1])/Double.valueOf(Mainnum.getValue()));
                break;
        }

    }
    return value;
}
}
