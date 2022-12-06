// import java.lang.*;
import java.awt.*;
import javax.swing.*;
// import javax.swing.event.*;
import java.awt.event.*;

class Input{
    public void shaper_ai(int x,int y ,Graphics g)
    {
        g.setColor(new Color(100,100,230));//blue
        g.fillOval(x,y,60,60);
    }
    public void shaper_user(int x ,int y,Graphics g)
    {
        g.setColor(new Color(255,0,0));//red
        g.fillOval(x,y,60,60);
    }
}
class MyFrame extends JFrame {
    Input adder ;
    int posx = -1;
    int posy= -1;
    int posai = -1 ; 
    static int occ = 0 ;
    int ai_paint=0;
    int arr[][];
    MyFrame()
    {
       // GroupLayout gb = new GroupLayout(rootPane);
        adder = new Input();
        arr = new int[3][3];
        for(int i = 0 ;i<3;i++){for(int j = 0 ; j < 3 ;j ++ ){arr[i][j]=-1;}}
        setLayout(new FlowLayout());
        addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent me){
                posx = me.getX();
                posy = me.getY();
                occ = occ + 1; 
                repaint();

        }});

    }
    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        //g.drawLine(0, 0, 300, 0);
        g.drawLine(110, 0, 110, 330);
        g.drawLine(220, 0, 220, 330);
        g.drawLine(0, 110, 330, 110);
        g.drawLine(0, 220, 330, 220);
        if(posai==-1)
        {
            if(posx!=-1 && posy!=-1)
            {
                if(posx>=0 && posx<=100)
                {
                    if(posy>=0 && posy<=100 && arr[0][0]==-1)
                    {
                        adder.shaper_user(30,40,g);
                        arr[0][0] = 1; 
                        ai_paint = 1 ;
                    }
                    else if(posy>100 && posy<=200 && arr[1][0]==-1)
                    {
                        adder.shaper_user(30,140,g);
                        arr[1][0] = 1 ; 
                        ai_paint = 1 ;
                    }
                    else if(posy>200 && posy<=300 && arr[2][0]==-1)
                    {
                        adder.shaper_user(30,240,g);
                        arr[2][0] = 1;
                        ai_paint = 1 ;
                    }
                
                }
                else if(posx>100 && posx<=200)
                {
                    if(posy>=0 && posy<=100 && arr[0][1]==-1)
                    {
                        adder.shaper_user(130,40,g);
                        arr[0][1] = 1 ; 
                        ai_paint = 1 ;
                    }
                    else if(posy>100 && posy<=200 && arr[1][1]==-1)
                    {
                        adder.shaper_user(130,140,g);
                        arr[1][1] = 1; 
                        ai_paint = 1 ;
                    }
                    else if(posy>200 && posy<=300 && arr[2][1]==-1)
                    {
                        adder.shaper_user(130,240,g);
                        arr[2][1] = 1 ; 
                        ai_paint = 1 ;
                    }
                
                }
                else if(posx>200 && posx<=300)
                {
                    if(posy>=0 && posy<=100 && arr[0][2]==-1)
                    {
                        adder.shaper_user(230,40,g);
                        arr[0][2] = 1 ; 
                        ai_paint = 1 ;
                    }
                    else if(posy>100 && posy<=200 && arr[1][2]==-1)
                    {
                        adder.shaper_user(230,140,g);
                        arr[1][2] = 1 ; 
                        ai_paint = 1 ;
                    }
                    else if(posy>200 && posy<=300 && arr[2][2]==-1)
                    {
                        adder.shaper_user(230,240,g);
                        arr[2][2] = 1; 
                        ai_paint = 1 ;
                    }
                
                }
            }
        }
        else
        {
            if(posai==0)
            {
                adder.shaper_ai(30,40,g);
            }
            else if(posai==1)
            {
                adder.shaper_ai(130,40,g);
            }
            else if(posai==2)
            {
                adder.shaper_ai(230,40,g);
            }
            else if(posai==3)
            {
                adder.shaper_ai(30,140,g);
            }
            else if(posai==4)
            {
                adder.shaper_ai(130,140,g);
            }
            else if(posai==5)
            {
                adder.shaper_ai(230,140,g);
            }
            else if(posai==6)
            {
                
                adder.shaper_ai(30,240,g);
            }
            else if(posai==7)
            {
                adder.shaper_ai(130,240,g);
            }
            else if(posai==8)
            {
                adder.shaper_ai(230,240,g);
            }
        }
        int d1 = Checker(arr);
        if(d1==1)
        {
            JOptionPane.showMessageDialog(null,"Player - 1"+" Won!!"); 
        }
        else if(d1==10)
        {
            JOptionPane.showMessageDialog(null,"AI" +" Won!!"); 
        }
        else if(d1==6)
        {
            JOptionPane.showMessageDialog(null,"It is a Draw!!"); 
        }
        else {
            if(posai==-1 && ai_paint == 1)
            { 
            int value = MinMax(0,1,arr);
            int count_box = 0 ;
            //System.out.println("value" + value );
            int cond = 0 ;
            for(int i = 0 ; i <arr.length;i++)
            {
                if(cond==1){break;}
                for(int j = 0 ; j < arr[i].length;j++)
                {
                    if(arr[i][j]==-1)
                    {
                        if(value == 0 )
                        {
                            arr[i][j]  = 0 ;
                            //System.out.println("Countbox:" + count_box);
                            posai = count_box;
                            cond=1;
                            break;
                        }
                        value = value - 1 ;
                    }
                    else{}
                    count_box = count_box + 1 ;
                }
            }
            occ = occ +1 ;
            ai_paint = 0;
            repaint();
            }
            else
            {           
                posai = -1  ;
            }
        }
    }
    public int MinMax(int step,int move,int arr[][])
    {
        //createobj of checker method
        int parr[][] = new int[arr.length][];
        for(int i = 0 ; i<arr.length;i++)
        {
            parr[i] = arr[i].clone();
        }
        int result[]  = new int[9] ;
        for(int i = 0 ;i<9;i++)
        {
            result[i] = -100 ;
         }
        int pos = 0 ; 
        while(true)
        {
            if(move==1)
            {
                for(int i = 0 ; i<arr.length;i++)
                {
                    for(int j =0 ;j<arr[i].length;j++)
                    {
                        if(parr[i][j]==-1)
                        {
                            parr[i][j] =  0 ; //move of ai
                            result[pos] = Checker(parr);
                            if(result[pos]==5)
                            {
                                result[pos] = MinMax(step+1,0,parr);
                            }
                            pos = pos +1 ;
                        }
                    }
                }
            }
            else
            {
                for(int i = 0 ; i <arr.length;i++)
                {
                    for(int j = 0 ; j < arr[i].length;j++)
                    {
                        if(parr[i][j]==-1)
                        {
                            parr[i][j] = 1 ;
                            result[pos] = Checker(parr);
                            if(result[pos]==5)
                            {
                                result[pos] = MinMax(step+1,1,parr);
                            }
                            pos = pos + 1 ;
                        }
                    }
                }
            }
            int value = -100;
            int ps  = 0 ;
            if(step%2==0)//Max
            {
                for(int i = 0 ; i < pos ;i++)
                {
                    if(value==-100)
                    {
                        value = result[i];
                        ps = i ;
                    }
                    else if(value<result[i])
                    {
                        value = result[i];
                        ps = i ;
                    }
                }
            }
            else
            {
                for(int i = 0 ; i < pos ;i++)
                {
                    if(value==-100)
                    {
                        value = result[i];
                        ps = i ;
                    }
                    else if(value >result[i])
                    {
                        value = result[i];
                        ps = i ;
                    }
                }
            }
            if(step ==0)
            {
                return ps ;
            }
            return value ; 
        }
    }
    public static int Checker(int arr[][])
    {
        int i = 0 ;
        int cond = 0 ;
        while(i<3)
        {
            if(arr[i][0]==arr[i][1] && arr[i][0]==arr[i][2] && arr[i][0]!=-1)
            { 
                cond =  arr[i][0];
            }
            i = i + 1 ;
        }
        i = 0 ;
        if(cond==0)
        {
        while(i<3)
        {
            if(arr[0][i]==arr[1][i] && arr[0][i]==arr[2][i] && arr[0][i]!=-1)
            {
                cond = arr[0][i];
            }
            i = i +  1;
        }}
        if(cond==0)
        {
        if(arr[0][0]==arr[1][1] && arr[0][0]==arr[2][2] && arr[0][0]!=-1)
        {
            cond = arr[0][0];
        }
        else if (arr[0][2]==arr[1][1] && arr[0][2]==arr[2][0] && arr[0][2]!=-1)
        { 
            cond = arr[0][2];
        }
        else
        {
            cond = -1; 
        }}
        if(cond==1)
        {
            return 1;
        }
        else if(cond==0 ){
            return 10; 
        }
        else if(occ==10)
        {
            return 6;
        }
        else {
            return 5 ; 
        }
    }
}

public class tictactoe{
    public static void main(String[] args) {
        MyFrame OBJ = new MyFrame();
        OBJ.setSize(330,330);
        OBJ.setVisible(true);
        OBJ.setDefaultCloseOperation(3);
    }
}
