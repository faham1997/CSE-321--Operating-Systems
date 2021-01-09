import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import java.lang.Math;
import javax.swing.JFrame;

public class Lab04 implements GLEventListener{
   
   private GLU glu;
   @Override
   public void display(GLAutoDrawable drawable) {
     final GL2 gl = drawable.getGL().getGL2();
     gl.glClear(GL2.GL_COLOR_BUFFER_BIT);     
     gl.glPointSize(3.0f);
     gl.glColor3d(1, 1, 1);
     gl.glBegin(GL2.GL_POINTS);
      
     DrawMPC(gl, -10, 0, 5);
     DrawMPC(gl, 0, 0, 5);
     DrawMPC(gl, 10, 0, 5);
     DrawMPC(gl, 20, 0, 5);
     DrawMPC(gl, 30, 0, 5);
     
     
     DrawMPC(gl,  25, -5, 5);
     DrawMPC(gl,  20, -10, 5);
     DrawMPC(gl,  15, -15, 5);
     DrawMPC(gl,  10, -20, 5);
     DrawMPC(gl,  5, -25, 5);
     DrawMPC(gl,  0, -30, 5);

     gl.glEnd();
   }
   
   @Override
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }
   
   @Override
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
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

   public void DrawMPC(GL2 gl, float x, float y, float r) {
        double newX = 0, newY=r;
        double d = 1-r;
        while(newY>newX){
            if(d<0){
                newX++;
                newY--;
                d = d+2*newX+1;
            }else if(d>=0){
                newX++;
                d = d+2*(newX-newY)+5;
            }
            gl.glVertex2d(newX+x, newY+y);
            gl.glVertex2d(newY+x, newX+y);
            gl.glVertex2d(-newX+x, newY+y);
            gl.glVertex2d(-newY+x, newX+y);
            gl.glVertex2d(-newX+x, -newY+y);
            gl.glVertex2d(-newY+x, -newX+y);
            gl.glVertex2d(newX+x, -newY+y);
            gl.glVertex2d(newY+x, -newX+y);                
        }
    }

   public static void main(String[] args) {
      final GLProfile profile = GLProfile.get(GLProfile.GL2);
      GLCapabilities capabilities = new GLCapabilities(profile);
      final GLCanvas glcanvas = new GLCanvas(capabilities);
      Lab04 l = new Lab04();
      glcanvas.addGLEventListener(l);
      glcanvas.setSize(400, 400);
      final JFrame frame = new JFrame ("LAB04-18101107");
      frame.getContentPane().add(glcanvas);
      frame.setSize(frame.getContentPane().getPreferredSize());
      frame.setVisible(true);
   }
}
