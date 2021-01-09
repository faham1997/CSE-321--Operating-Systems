import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import javax.swing.JFrame;

public class Lab03 implements GLEventListener{
   
   private GLU glu;
   @Override
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
      gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
      
      gl.glPointSize(3.0f);
      gl.glColor3d(1, 1, 1);
      gl.glBegin(GL2.GL_POINTS);
      
      DrawMPL(gl, 0, 0, 0, 30 );
      DrawMPL(gl, 0, 0, -20, 0 );
      DrawMPL(gl, 0, 30, -20, 30 );
      DrawMPL(gl, -20, 0, -20, 30 );
      
      DrawMPL(gl, 70, 30, 40, 30 );
      DrawMPL(gl, 70, 30, 40, 0 );
      
    gl.glEnd();
   }
   @Override
   public void dispose(GLAutoDrawable arg0) {
   }
   
   @Override
   public void init(GLAutoDrawable gld) {
       GL2 gl = gld.getGL().getGL2();
       glu = new GLU();

       gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
       gl.glViewport(-100, -50, 50, 100);
       gl.glMatrixMode(GL2.GL_PROJECTION);
       gl.glLoadIdentity();
       glu.gluOrtho2D(-100.0, 100.0, -100.0, 100.0);
   }

   @Override
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
	   
   }
   
   public int findZone(float x1, float y1, float x2, float y2){
       float dx = x2-x1;
       float dy = y2-y1;
       int zone;
       if(dx>0){
           if(dy>0){
               if(Math.abs(dx)>Math.abs(dy)){
                   zone = 0;
               }else{
                   zone = 1;
               }
           }else{
               if(Math.abs(dx)>Math.abs(dy)){
                   zone = 6;
               }else{
                   zone = 7;
               }
           }
       }else{
           if(dy>0){
               if(Math.abs(dx)>Math.abs(dy)){
                   zone = 3;
               }else{
                   zone = 2;
               }
           }else{
               if(Math.abs(dx)>Math.abs(dy)){
                   zone = 4;
               }else{
                   zone = 5;
               }
           }
       }
       return zone;
   }
      
   public void zone0(GL2 gl,float x0, float y0,float x1, float y1,int zone, float dx, float dy){
       float dE = dy;
       float dNE = (dy - dx);
       float d = (dy) - dx;
       float x = x0, y = y0;
       
       while (x <= x1){
            if (d < 0){
                x++;
                d = d + dE;
            }else{
                x++;
                y++;
                d = d + dNE;
            }
            gl.glVertex2f(x,y);
        }
   }
   
   public void zone1(GL2 gl, float x0, float y0, float x1, float y1, int zone, float dx, float dy){
        float dN = -dx;
        float dNE = (dy - dx);
        float d = (dy / 2) - (dx);
        float x = x0, y = y0;

        while (y <= y1){
            if (d >= 0){
                y++;
                d = d + dN;
            }else{
                y++;
                x++;
                d = d + dNE;
            }
            gl.glVertex2f(x, y);
        }
    }

    public void zone2(GL2 gl, float x0, float y0, float x1, float y1, int zone, float dx, float dy){
        float dN = -dx;
        float dNW = (-dy - dx);
        float d = (-dy / 2) - (dx);
        float x = x0, y = y0;

        while (y <= y1){
            if (d < 0){
                y++;
                d = d + dN;
            } else{
                y++;
                x--;
                d = d + dNW;
            }
            gl.glVertex2f(x, y);
        }

    }

    public void zone3(GL2 gl, float x0, float y0, float x1, float y1, int zone, float dx, float dy){
        float dW = -dy;
        float dNW = (-dy - dx);
        float d = (-dy) - (dx / 2);
        float x = x0, y = y0;
        
        while (x1 <= x){
            if (d >= 0){
                x--;
                d = d + dW;
            } else{
                y++;
                x--;
                d = d + dNW;
            }
            gl.glVertex2f(x, y);
        }
    }

    public void zone4(GL2 gl, float x0, float y0, float x1, float y1, int zone, float dx, float dy){
        float dW = -dy;
        float dSW = (-dy + dx);
        float d = (-dy) + (dx / 2);
        float x = x0, y = y0;
        
        while (x1 <= x){
            if (d >= 0){
                x--;
                y--;
                d = d + dSW;
            } else{
                x--;
                d = d + dW;
            }
            gl.glVertex2f(x, y);
        }
 
    }

    public void zone5(GL2 gl, float x0, float y0, float x1, float y1, int zone, float dx, float dy){
        float dS = dx;
        float dSW = (-dy + dx);
        float d = -(dy / 2) + (dx);
        float x = x0, y = y0;

        while (y1 <= y){
            if (d < 0){
                x--;
                y--;
                d = d + dSW;
            } else{
                y--;
                d = d + dS;
            }
            gl.glVertex2f(x, y);
        }
        
    }

    public void zone6(GL2 gl, float x0, float y0, float x1, float y1, int zone, float dx, float dy){
        float dS = dx;
        float dSE = (dy + dx);
        float d = (dy / 2) + (dx);
        float x = x0, y = y0;

        while (y1 <= y){
            if (d >= 0){
                x++;
                y--;
                d = d + dSE;
            } else{
                y--;
                d = d + dS;
            }
            gl.glVertex2f(x, y);
        }
        
    }

    public void zone7(GL2 gl, float x0, float y0, float x1, float y1, int zone ,float dx, float dy){
        float dE = dy;
        float dSE = (dy + dx);
        float d = (dy) + (dx / 2);
        float x = x0, y = y0;

        while (x <= x1){
            if (d >= 0){
                x++;
                d = d + dE;
            } else{
                x++;
                y--;
                d = d + dSE;
            }
            gl.glVertex2f(x, y);
        }
        
    }

    public void DrawLine(GL2 gl, float x0, float y0, float x1, float y1, int zone){
    	float dx = x1 - x0, dy = y1 - y0;
        switch(zone){
            case 0:
            	zone0(gl,x0,y0,x1,y1,zone,dx,dy);
                break;
            case 1:
            	zone1(gl,x0,y0,x1,y1,zone,dx,dy);
                break;
            case 2:
            	zone2(gl,x0,y0,x1,y1,zone,dx,dy);
                break;
            case 3:
            	zone3(gl,x0,y0,x1,y1,zone,dx,dy);
                break;
            case 4:
            	zone4(gl,x0,y0,x1,y1,zone,dx,dy);
                break;
            case 5:
            	zone5(gl,x0,y0,x1,y1,zone,dx,dy);
                break;
            case 6:
            	zone6(gl,x0,y0,x1,y1,zone,dx,dy);
                break;
            case 7:
            	zone7(gl,x0,y0,x1,y1,zone,dx,dy);
                break;
        }

    }
   public void DrawMPL(GL2 gl, float x1, float y1, float x2, float y2) {
       int zone = findZone(x1, y1, x2, y2);
       DrawLine(gl, x1, y1, x2, y2, zone);  
    }

   public static void main(String[] args) {
      final GLProfile profile = GLProfile.get(GLProfile.GL2);
      GLCapabilities capabilities = new GLCapabilities(profile);
      final GLCanvas glcanvas = new GLCanvas(capabilities);
      Lab03 l = new Lab03();
      glcanvas.addGLEventListener(l);
      glcanvas.setSize(500, 500);
      final JFrame frame = new JFrame ("LAB 03");
      frame.getContentPane().add(glcanvas);
      frame.setSize(frame.getContentPane().getPreferredSize());
      frame.setVisible(true);
   }
}
