// Animate sorting algorithms
import java.awt.*;
import java.util.Date;
import java.util.EventObject;
import java.lang.Object;
import javax.swing.*;

public class SortAnim extends JPanel{
    // Screen Elements
    private TextField n_text;
    private Choice distChoice;
    private Choice algChoices;
    private Button runButton;
    private Label msgLabel;
    private Color drawColor = Color.black;
    private Color backColor = Color.white;

    // SORTING DATA AND ALGS
    static private final int MAXN = 10000;
    static private int n = 100;
    static private float a[] = new float[MAXN];

    // Sorting: Generate Inputs
    static private final int GEN_RAND = 0;
    static private final int GEN_ASCEND = 1;
    static private final int GEN_DESCEND = 2;
    static private int gen_Num = GEN_RAND;

    private void genArray() {
        for (int i = 0; i < n; i++) {
            switch (gen_Num) {
                case GEN_RAND: 
                    a[i] = (float) Math.random();
                    break;
                case GEN_ASCEND: 
                    a[i] = ((float) i) / n;
                    break;
                case GEN_DESCEND: 
                    a[i] = (float) (1.0 - ((float) i) / n);
                    break;
            }
        }
    }

    // Sorting: Supporting Algs
    private void baseSwap(int i, int j) {
        float t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // Sorting: Animation Support
    static private final int MINX = 20, MAXX = 580;
    static private final int MINY = 50, MAXY = 380;
    static private float factorX, factorY;
    static private boolean wantAnim = true;

    private void initDisplay() {
        Graphics g = this.getGraphics();
        Rectangle r = this.getBounds();
        g.setColor(backColor);
        g.fillRect(r.x, r.y, r.width, r.height);
        factorX = ((float) MAXX - MINX) / n;
        factorY = ((float) MAXY - MINY);
    }

    private void draw(int i, Color color) {
        Graphics g = this.getGraphics();
        int d = 4;
        int px = (int) (MINX + factorX * i);
        int py = MAXY - (int) (factorY * a[i]);
        g.setColor(color);
        g.drawOval(px, py, d, d);
    }

    private void swap(int i, int j) {
        if (wantAnim) {
            draw(i, backColor);
            draw(j, backColor);
        }
        baseSwap(i, j);
        if (wantAnim) {
            draw(i, drawColor);
            draw(j, drawColor);
        }
    }

    // Sorting Algs
    private void iSort() {
        for (int i = 1; i < n; i++)
            for (int j = i; (j > 0) && (a[j-1] > a[j]); j--)
                swap(j - 1, j);
    }

    private void sSort() {
        for (int i = 0; i < n - 1; i++)
            for (int j = i; j < n; j++)
                if (a[j] < a[i])
                    swap(i, j);
    }

    private void shellShort() {
        int i, j, h;
        for (h = 1; h < n; h = 3*h + 1);
        for (;;) {
            h /= 3;
            if (h > 1) 
                break;
            for (i = h; i < n; i++) {
                for (j = i; j >= h; j -= h) {
                    if (a[j-h] < a[j])
                        break;
                    swap(j-h, j);
                }
            }
        }
    }

    private void shiftDown(int l, int u) {
        int i, c;
        i = 1;
        for (;;) {
            c = 2*i;
            if (c > u)
                break;
            if ((c+1 <= u) && (a[c+1] > a[c]))
                c++;
            if (a[i] >= a[c])
                break;
            swap(i, c);
            i = c;
        }
    }

    private void headSort() {   // BEWARE!!! Sorts x[1...n-1]
        int i;
        for (i = n/2; i > 0; i--)
            shiftDown(i, n-1);
        for (i = n-1; i >= 2; i--) {
            swap(1, i);
            shiftDown(1, i-1);
        }
    }

    private void qSort(int l, int u) {
        if (l >= u)
            return;
        int m = l;
        for (int i = l+1; i <= u; i++)
            if (a[i] < a[l])
                swap(++m, i);
        swap(l, m);
        qSort(l, m-1);
        qSort(m+1, u);
    }

    private void qSort2(int l, int u) {
        if (l >= u)
            return;
        int i = l;
        int j = u + 1;
        for (;;) {
            do { i++; } while ((i <= u) && (a[i] < a[l]));
            do { j--; } while (a[j] > a[l]);
            if (i > j)  break;
            swap(i, j);
        }
        swap(l, j);
        qSort2(l, j-1);
        qSort2(j+1, u);
    }

    // Drive Sort
    static private final int ALG_ISORT      = 0;
    static private final int ALG_SELSORT    = 1;
    static private final int ALG_SHELLSORT  = 2;
    static private final int ALG_HSORT      = 3;
    static private final int ALG_QSORT      = 4;
    static private final int ALG_QSORT2     = 5;
    static private int alg_num = ALG_ISORT;

    private void doSort() {
        switch (alg_num) {
            case ALG_ISORT:     iSort();        break;
            case ALG_SELSORT:   sSort();        break;
            case ALG_SHELLSORT: shellShort();   break;
            case ALG_HSORT:     headSort();     break;
            case ALG_QSORT:     qSort(0, n-1);  break;
            case ALG_QSORT2:    qSort2(0, n-1); break;
        }
    }

    private void runAnim() {
        n = Integer.parseInt(n_text.getText());
        if (n < 1 || n > MAXN) {
            n = 50;
            n_text.setText("" + n);
        }

        initDisplay();
        
        msgLabel.setText("Running");
        genArray();
        
        for (int i = 0; i < n; i++)
            draw(i, drawColor);
        
        Date timer = new Date();
        long start = timer.getTime();
        
        doSort();

        timer = new Date();
        long msecs = timer.getTime() - start;

        msgLabel.setText("Msecs: " + msecs);

        if (wantAnim)   // Draw results over input
            for (int i = 0; i < n; i++)
                draw(i, drawColor);
    }

    // GUI FUNCTIONS
    public void init() {
        this.setBackground(backColor);

        // TextField for n (problem size)
        n_text = new TextField(5);
        this.add(new Label("n:"));
        this.add(n_text);
        n_text.setText("" + n);

        // Choices of Starting distributions
        distChoice = new Choice();
        distChoice.addItem("Random");
        distChoice.addItem("Ascending");
        distChoice.addItem("Descending");
        this.add(new Label("Input:"));
        this.add(distChoice);

        // Choice of Sort Algorithms
        algChoices = new Choice();
        algChoices.addItem("Insertion Sort");
        algChoices.addItem("Selection Sort");
        algChoices.addItem("Shell Sort");
        algChoices.addItem("Heap Sort");
        algChoices.addItem("Quicksort");
        algChoices.addItem("2-way Quicksort");
        this.add(new Label("Algoritm:"));
        this.add(algChoices);

        // Run Button
        runButton = new Button("Run");
        this.add(runButton);

        // Message Label
        msgLabel = new Label("                  ");
        this.add(msgLabel);
    }

    public boolean action(AWTEvent event, Object arg) {
        if (event.getSource() == distChoice) {
                 if (arg.equals("Random"))          gen_Num = GEN_RAND;
            else if (arg.equals("Ascending"))       gen_Num = GEN_ASCEND;
            else if (arg.equals("Descending"))      gen_Num = GEN_DESCEND;
            return true;
        } else if (event.getSource() == algChoices) {
                 if (arg.equals("Insertion Sort"))  alg_num = ALG_ISORT;
            else if (arg.equals("Selection Sort"))  alg_num = ALG_SELSORT;
            else if (arg.equals("Shell Sort"))      alg_num = ALG_SHELLSORT;
            else if (arg.equals("Heap Sort"))       alg_num = ALG_HSORT;
            else if (arg.equals("Quicksort"))       alg_num = ALG_QSORT;
            else if (arg.equals("2-way Quicksort")) alg_num = ALG_QSORT2;
            return true;
        } else if (event.getSource() == runButton) {
            runAnim();
            return true;
        } else
            return false;
    }

    private JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new SortAnim()::createAndShowGui);
    }

    private void createAndShowGui() {
        frame = new JFrame(getClass().getSimpleName());

        this.setOpaque(true);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
