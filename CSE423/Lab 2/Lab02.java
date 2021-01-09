import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import javax.swing.JFrame;

public class Lab02 implements GLEventListener {

    private GLU glu;

    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        
        DDA(gl, 0, 0, 0, 10 );
        DDA(gl, 0, 0, 10, 0 );
        DDA(gl, 0, 10, 10, 10 );
        DDA(gl, 10, 0, 10, 10 );
        DDA(gl, 20, 10, 30, 10 );
        DDA(gl, 20, 0, 30, 10 );
         
    }

    public void dispose(GLAutoDrawable arg0) {
        //method body
    }

    public void init(GLAutoDrawable gld) {
        GL2 gl = gld.getGL().getGL2();
        glu = new GLU();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glViewport(-250, -250, 250, 250);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-100.0, 100.0, -100.0, 100.0);
    }

    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
        // method body
    }

    public void DDA(GL2 gl, float x0, float y0, float x1, float y1) {

        gl.glPointSize(5.0f);
        gl.glColor3d(1, 1, 1);

        float m = (y1 - y0) / (x1 - x0);
        float x = x0;
        float y = y0;

        if (m < 1 && m > -1 ) {
            while (x < x1) {
                x = x + 1;
                y = y + m;
                gl.glBegin(GL2.GL_POINTS);
                gl.glVertex2d(x, y);
                gl.glEnd();
            }
        }
        else {
            while (y < y1) {
                y = y + 1;
                x = x + (1 / m);
                gl.glBegin(GL2.GL_POINTS);
                gl.glVertex2d(x, y);
                gl.glEnd();
            }
        }
    }
    public static void main(String[] args) {
        //getting the capabilities object of GL2 profile
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        // The canvas 
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        Lab02 l = new Lab02();
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(500, 500);
        //creating frame
        final JFrame frame = new JFrame("LAB02");
        //adding canvas to frame
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
    }//end of main
}//end of classimport javax.media.opengl.GL2;