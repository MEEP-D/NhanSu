package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import DTO.EXCEL;
import run.App;

public class xuatFileLuong extends MouseAdapter{
	private App app;
	public xuatFileLuong(App app) {
		this.app = app;
	}
	public void mouseClicked(MouseEvent e) {
		JFileChooser jf = new JFileChooser();
		jf.setFileFilter(new FileFilter() {
			public String getDescription() {
				// TODO Auto-generated method stub
				return "Excel file";
			}
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				String name = f.getName();
				return f.isDirectory() || name.endsWith(".xlsx");
			}
		});
		int flag = jf.showOpenDialog(app);
		if(flag==JFileChooser.APPROVE_OPTION) {
			File file = jf.getSelectedFile();
			System.out.println(file.getAbsolutePath());
			if(file.getAbsoluteFile().toString().endsWith(".xlsx")) {
				EXCEL.exportSalaryData(app.getContent().getSalaryForm().getSalaryForm1().getData(), file.getAbsolutePath().toString());
			}else {
				EXCEL.exportSalaryData(app.getContent().getSalaryForm().getSalaryForm1().getData(),file.getAbsolutePath().toString()+".xlsx");
				
			}
			app.showMessage("Đã lưu thành công!");
		}
	}
}
