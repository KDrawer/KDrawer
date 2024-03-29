package kdr.gui.popup;

import kdr.gui.*;
import javax.swing.*;

public class KFigurePopup extends KObjectPopup
{
	static int nThickness = 4;
	protected JMenuItem fillItem;
	protected JMenuItem resizeItem;
	protected JRadioButtonMenuItem[] thichnessItem;

	public KFigurePopup(DrawerView view, String title, boolean fillFlag) {
		super(view,title);

		resizeItem = new JMenuItem(DrawerView.Labels.get("Resize"));
		resizeItem.addActionListener((evt) -> view.resizeFigure());
		popupPtr.add(resizeItem);

		JMenu colorMenu = new KColorSubmenu(view);
		popupPtr.add(colorMenu);

		JMenu thicknessMenu = new JMenu(DrawerView.Labels.get("Thickness"));
		popupPtr.add(thicknessMenu);

		ButtonGroup group = new ButtonGroup();
		thichnessItem = new JRadioButtonMenuItem[nThickness];
		for(int i = 0; i < thichnessItem.length; i++) {
			thichnessItem[i] = new JRadioButtonMenuItem(""+(i+1));
			int thichness = i+1;
			thichnessItem[i].addActionListener(
				(evt) -> view.setThicknessForSelectedFigure(thichness));
			group.add(thichnessItem[i]);
			thicknessMenu.add(thichnessItem[i]);
		}
		thichnessItem[0].setSelected(true);
		
		if (fillFlag)
		{
			fillItem = new JMenuItem(DrawerView.Labels.get("Fill"));
			fillItem.addActionListener((evt) -> view.fillFigure());
			popupPtr.add(fillItem);
		}		
	}
	public void setThicknessSeletion(int n) {
		thichnessItem[n-1].setSelected(true);
	}
}

