package vol1.ch08;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class SwingWorkerTest extends JFrame {
  JButton button = null;
  JTextArea textArea = null;
  JProgressBar progressBar = null;
  PrimeNumbersTask task = null;

  public static void main(String[] args) {
    SwingWorkerTest w = new SwingWorkerTest( "SwingWorkerTest" );
  }
  public SwingWorkerTest( String title ) {
    super( title );
    JPanel pane = (JPanel)getContentPane();
    pane.setLayout( new FlowLayout() );
    textArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setPreferredSize( new Dimension(160, 300) );
    progressBar = new JProgressBar(0, 100);
    Action action = new ButtonAction();
    action.putValue( Action.NAME, "Cancel" );
    button = new JButton( action );
    pane.add(scrollPane);
    pane.add(progressBar);
    pane.add(button);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setSize( 250, 450 );
    setVisible( true );
    
    task = new PrimeNumbersTask(textArea, 5000000);
    task.addPropertyChangeListener(
    new PropertyChangeListener() {
      public void propertyChange(PropertyChangeEvent evt) {
        if ("progress".equals(evt.getPropertyName())) {
          progressBar.setValue( (Integer)evt.getNewValue() );

        }
      }
    });

    task.execute();
    try {
      List<Integer> r = task.get();
      System.out.println("Count:" + r.size() ); 
    }
    catch( Exception e) {
    }
  }

  class PrimeNumbersTask extends
    SwingWorker<List<Integer>, Integer> {

    int current = 1;
    int numbersToFind = 1;
    PrimeNumbersTask(JTextArea textArea, int n) {
      numbersToFind = n;
    }

    @Override
    public List<Integer> doInBackground() {
      List<Integer> numbers = new ArrayList<Integer>();
      numbers.add(1);
      boolean worked = true;
      while (! isCancelled() ) {
        int next = getNextPrimeNumber();
        if( current >= numbersToFind ) break;
        numbers.add( next );
        publish( next ); 
        setProgress( 100 * current / numbersToFind );
      }
      if( ! isCancelled() ) setProgress(100);
      return numbers;
    }

    @Override
    protected void process( List<Integer> primeNumbers ) {
       for ( int number : primeNumbers ) {
         textArea.append( number + "\n" );
       }
    }

    private boolean IsPrime( int n ){
      int i = 0;
      if( n < 2 ) return true;
      else if( n == 2 ) return false;
      if( n % 2 == 0 ) return false;
      for( i = 3; i * i <= n; i += 2 )
        if( n % i == 0 ) return false;
      return true;
    }

    private int getNextPrimeNumber() {
      boolean b = false;
      while( !b ) {
        b = IsPrime( ++current );
      }
      return current;
    }
  }
  class ButtonAction extends AbstractAction {
    public void actionPerformed(ActionEvent e) {
      task.cancel(true);
      if( task.isCancelled() ) System.out.println("Cancelled!");
    }
  }
}