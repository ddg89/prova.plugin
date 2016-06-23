package listeners;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Text;

import model.Evl;

public class port2eplListener implements SelectionListener {
	private Evl evl;
	private Text console;
	public port2eplListener(Evl evl , Text console){
		this.evl=evl;
		this.console=console;
	}
	@Override
	public void widgetSelected(SelectionEvent e) {
		try {
			File file = new File(Platform.getLocation()+"\\temp.evl");
			FileWriter fw;
			fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(evl.toString());
			bw.flush();
			bw.close();
			console.append("\n saving tempo evl to port .. C:\\temp.evl");
			//port2epl(file);
			file.delete();
			console.append("\n temp file deleted!");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
			console.append("\n" + e1.getMessage() );
		}

	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		try {
			File file = new File(Platform.getLocation()+"\\temp.evl");
			FileWriter fw;
			fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(evl.toString());
			bw.flush();
			bw.close();
			console.append("\n saving tempo evl to port .. C:\\temp.evl");
			//port2epl(file);
			file.delete();
			console.append("\n temp file deleted!");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
			console.append("\n" + e1.getMessage() );
		}

	}

}
