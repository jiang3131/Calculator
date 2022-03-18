package com.gyj.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.View;

import com.gyj.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;//存组件
    private MyViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        myViewModel=new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class); //获取数据模型
        myViewModel.getMainnum().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.BigTextView.setText(myViewModel.getMainnum().getValue());//该大框
                if (myViewModel.sign2.equals("")) {
                    if (myViewModel.sign1.equals("")) {
                        binding.SmallTextView.setText(myViewModel.getMainnum().getValue());
                    } else {
                        binding.SmallTextView.setText(myViewModel.num[0] + myViewModel.sign1 + myViewModel.getMainnum().getValue());
                    }
                }else{
                    binding.SmallTextView.setText(myViewModel.num[0]+ myViewModel.sign1+myViewModel.num[1]+ myViewModel.sign2+myViewModel.getMainnum().getValue());
                }
            }
        });

        binding.button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.setMainnum("0");
            }
        });
        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.setMainnum("1");
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.setMainnum("2");
            }
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.setMainnum("3");
            }
        });
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.setMainnum("4");
            }
        });
        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.setMainnum("5");
            }
        });
        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.setMainnum("6");
            }
        });
        binding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.setMainnum("7");
            }
        });
        binding.button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.setMainnum("8");
            }
        });
        binding.button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.setMainnum("9");
            }
        });
        binding.buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!myViewModel.havepoint){
                    myViewModel.getMainnum().setValue(myViewModel.getMainnum().getValue()+".");
                    myViewModel.havepoint=true;
                }
            }
        });
        binding.buttonjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!myViewModel.getMainnum().getValue().equals("0")){
                    if(myViewModel.sign1.equals("")){
                        myViewModel.sign1="+";
                        myViewModel.num[0]=myViewModel.getMainnum().getValue();
                        myViewModel.getMainnum().setValue("0");
                        myViewModel.havepoint=false;
                    }else if(myViewModel.sign2.equals("")){// a+b
                        myViewModel.num[0]=myViewModel.mianNumWithnum0();
                        myViewModel.sign1="+";
                        myViewModel.getMainnum().setValue("0");
                        myViewModel.havepoint=false;
                    }else{//a+b*c
                        myViewModel.getMainnum().setValue(myViewModel.mianNumWithnum1());
                        myViewModel.sign2="";
                        myViewModel.num[1]="";
                        myViewModel.num[0]=myViewModel.mianNumWithnum0();
                        myViewModel.sign1="+";
                        myViewModel.getMainnum().setValue("0");
                        myViewModel.havepoint=false;

                    }
                }

            }
        });
        binding.buttonchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(!myViewModel.getMainnum().getValue().equals("0")){
                  if(myViewModel.sign1.equals("")){
                      myViewModel.sign1="*";
                      myViewModel.num[0]=myViewModel.getMainnum().getValue();
                      myViewModel.getMainnum().setValue("0");
                      myViewModel.havepoint=false;
                  } else if(myViewModel.sign2.equals("")){
                      if(myViewModel.sign1.equals("*")||myViewModel.sign1.equals("/")){
                          myViewModel.num[0]=myViewModel.mianNumWithnum0();
                          myViewModel.sign1="*";
                          myViewModel.getMainnum().setValue("0");
                          myViewModel.havepoint=false;
                      }else{
                          myViewModel.num[1]=myViewModel.getMainnum().getValue();
                          myViewModel.sign2="*";
                          myViewModel.getMainnum().setValue("0");
                          myViewModel.havepoint=false;
                      }
                  }else{//如果是a+b*c这样的
                      myViewModel.num[1] = myViewModel.mianNumWithnum1();
                      myViewModel.sign2="*";
                      myViewModel.getMainnum().setValue("0");
                      myViewModel.havepoint=false;
                  }
              }
            }
        });
        binding.buttonjian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!myViewModel.getMainnum().getValue().equals("0")){
                    if(myViewModel.sign1.equals("")){
                        myViewModel.sign1="-";
                        myViewModel.num[0]=myViewModel.getMainnum().getValue();
                        myViewModel.getMainnum().setValue("0");
                        myViewModel.havepoint=false;
                    }else if(myViewModel.sign2.equals("")){// a+b
                        myViewModel.num[0]=myViewModel.mianNumWithnum0();
                        myViewModel.sign1="-";
                        myViewModel.getMainnum().setValue("0");
                        myViewModel.havepoint=false;
                    }else{//a+b*c
                        myViewModel.getMainnum().setValue(myViewModel.mianNumWithnum1());
                        myViewModel.sign2="";
                        myViewModel.num[1]="";
                        myViewModel.num[0]=myViewModel.mianNumWithnum0();
                        myViewModel.sign1="-";
                        myViewModel.getMainnum().setValue("0");
                        myViewModel.havepoint=false;

                    }
            }}
        });
        binding.buttonchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!myViewModel.getMainnum().getValue().equals("0")) {
                    if (myViewModel.sign1.equals("")) {
                        myViewModel.sign1 = "/";
                        myViewModel.num[0] = myViewModel.getMainnum().getValue();
                        myViewModel.getMainnum().setValue("0");
                        myViewModel.havepoint = false;
                    } else if (myViewModel.sign2.equals("")) {
                        if (myViewModel.sign1.equals("*") || myViewModel.sign1.equals("/")) {
                            myViewModel.num[0] = myViewModel.mianNumWithnum0();
                            myViewModel.sign1 = "/";
                            myViewModel.getMainnum().setValue("0");
                            myViewModel.havepoint = false;
                        } else {
                            myViewModel.num[1] = myViewModel.getMainnum().getValue();
                            myViewModel.sign2 = "/";
                            myViewModel.getMainnum().setValue("0");
                            myViewModel.havepoint = false;
                        }
                    } else {//如果是a+b*c这样的
                        myViewModel.num[1] = myViewModel.mianNumWithnum1();
                        myViewModel.sign2 = "/";
                        myViewModel.getMainnum().setValue("0");
                        myViewModel.havepoint = false;
                    }
                }
            }


        });
        binding.buttonCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.getMainnum().setValue("0");
                myViewModel.havepoint=false;
                myViewModel.sign1="";
                myViewModel.sign2="";
                myViewModel.num[0]="";
                myViewModel.num[1]="";
            }
        });
        binding.buttoncalcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(myViewModel.sign2.equals("")){
                    if(!myViewModel.sign1.equals("")){
                        myViewModel.getMainnum().setValue(myViewModel.mianNumWithnum0());
                        if(myViewModel.getMainnum().getValue().contains("."))
                            myViewModel.havepoint=true;
                        else
                            myViewModel.havepoint=false;
                        myViewModel.num[0]="";
                        myViewModel.sign1="";
                    }else{
                        binding.SmallTextView.setText(myViewModel.getMainnum().getValue());
                    }
                }else {
                    myViewModel.getMainnum().setValue(myViewModel.mianNumWithnum1());
                    myViewModel.num[1]="";
                    myViewModel.sign2="";
                    myViewModel.getMainnum().setValue(myViewModel.mianNumWithnum0());
                    if(myViewModel.getMainnum().getValue().contains("."))
                        myViewModel.havepoint=true;
                    else
                        myViewModel.havepoint=false;
                    myViewModel.num[0]="";
                    myViewModel.sign1="";
                }
                binding.SmallTextView.setText(myViewModel.getMainnum().getValue());
            }
        });
        binding.buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!myViewModel.getMainnum().getValue().equals("0")){
                  myViewModel.getMainnum().setValue(myViewModel.getMainnum().getValue().substring(0,myViewModel.getMainnum().getValue().length()-1));
                    if(myViewModel.getMainnum().getValue().equals("")){
                        myViewModel.getMainnum().setValue("0");

                    }

                }
            }
        });
    }
}