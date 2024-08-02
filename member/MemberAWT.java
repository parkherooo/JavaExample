package member;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberAWT extends MFrame implements ActionListener {

	JButton b1, b2, b3, b4;
	List list;

	JLabel label;
	JTextField tf1, tf2, tf3, tf4;
	JPanel p1, p2, p3;
	JButton insBtn, upBtn, zipBtn;
	Vector<MemberBean> vlist;
	MemberMgr mgr;
	int num;
	ZipcodeFrame zf;
	
	public MemberAWT() {
		super(300, 450);
		setTitle("Member MAG Ver1.0");
		mgr = new MemberMgr();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		label = new JLabel("");
		viewList();
		add(label, BorderLayout.NORTH);
		b1 = new JButton("����");
		b2 = new JButton("����");
		b3 = new JButton("�Է�");
		b4 = new JButton("����Ʈ");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		p1 = new JPanel();
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		add(p1, BorderLayout.SOUTH);
		validate();
	}
	
	public void viewList() {
		label.setOpaque(true);
		label.setText("NO  NAME          PHONE                TEAM");
		label.setBackground(Color.CYAN);
		vlist = mgr.listMember();
		list = new List(vlist.size(),false);
		for (int i = 0; i < vlist.size(); i++) {
			MemberBean bean = vlist.get(i);
			String str =(i+1) + "    " ;
			str+= bean.getName().trim()+"    ";
			str+= bean.getPhone().trim()+ "       ";
			str+= bean.getTeam().trim()+ "    ";
			list.add(str);
		}
		//���� �� list ù��° �����ۿ� Ŀ������
		int len = list.getItemCount();
		if( len > 0) {
			list.select(0);
		}
		add(list,BorderLayout.CENTER);
	}
	
	public void insertForm() {
		label.setText("ȸ���Է���");
		label.setBackground(Color.GRAY);
		p3.setLayout(new GridLayout(7, 1));

		JPanel p4 = new JPanel();
		p4.add(new JLabel("NAME  :"));
		tf1 = new JTextField(20);
		p4.add(tf1);
		p3.add(p4);

		JPanel p5 = new JPanel();
		p5.add(new JLabel("PHONE  :"));
		tf2 = new JTextField(20);
		p5.add(tf2);
		p3.add(p5);

		JPanel p6 = new JPanel();
		p6.add(new JLabel("TEAM  :"));
		tf3 = new JTextField(20);
		p6.add(tf3);
		p3.add(p6);
		////////////////////////////////////////
		JPanel p10 = new JPanel();
		Choice ch = new Choice();
		ch.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				int i =ch.getSelectedIndex();
				if (i==0) {
					tf3.setText("");
				} else {
					tf3.setText(ch.getItem(i));
				}
			}
		});
		Vector<String> vlist = mgr.getTeamList();
		ch.add("���� �����ϼ���");
		for (int i = 0; i < vlist.size(); i++) {
			ch.add(vlist.get(i));
		}
		p10.add(ch);
		p3.add(p10);
		//////////////////////////////////////
		JPanel p7 = new JPanel();
		zipBtn = new JButton("�����ȣ");
		p7.add(zipBtn);
		p3.add(p7);
		
		JPanel p8 = new JPanel();
		p8.add(new JLabel("�ּ�  :"));
		tf4 = new JTextField(20);
		zipBtn.addActionListener(this);
		p8.add(tf4);
		p3.add(p8);

        JPanel p9 = new JPanel();
		insBtn = new JButton("����");
		insBtn.addActionListener(this);
		p9.add(insBtn);
		p3.add(p9);

		add(p3, BorderLayout.CENTER);
	}
	
	public void updateForm(MemberBean bean) {
		label.setText("ȸ��������");
		label.setBackground(Color.YELLOW);
		p3.setLayout(new GridLayout(7, 1));
		num = bean.getNum();
		JPanel p4 = new JPanel();
		p4.add(new JLabel("NAME  :"));
		tf1 = new JTextField(bean.getName(), 20);
		p4.add(tf1);
		p3.add(p4);

		JPanel p5 = new JPanel();
		p5.add(new JLabel("PHONE  :"));
		tf2 = new JTextField(bean.getPhone(), 20);
		p5.add(tf2);
		p3.add(p5);

		JPanel p6 = new JPanel();
		p6.add(new JLabel("TEAM  :"));
		tf3 = new JTextField(bean.getTeam(), 20);
		p6.add(tf3);
		p3.add(p6);
		JPanel p10 = new JPanel();
		Choice ch = new Choice();
		ch.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				int i =ch.getSelectedIndex();
				if (i==0) {
					tf3.setText("");
				} else {
					tf3.setText(ch.getItem(i));
				}
			}
		});
		Vector<String> vlist = mgr.getTeamList();
		ch.add("���� �����ϼ���");
		for (int i = 0; i < vlist.size(); i++) {
			ch.add(vlist.get(i));
		}
		p10.add(ch);
		p3.add(p10);

		JPanel p7 = new JPanel();
		zipBtn = new JButton("�����ȣ");
		p7.add(zipBtn);
		p3.add(p7);
		
		JPanel p8 = new JPanel();
		p8.add(new JLabel("�ּ�  :"));
		tf4 = new JTextField(bean.getAddress(), 20);
		zipBtn.addActionListener(this);
		p8.add(tf4);
		p3.add(p8);

		JPanel p9 = new JPanel();
		upBtn = new JButton("��������");
		upBtn.addActionListener(this);
		p9.add(upBtn);
		p3.add(p9);

		add(p3, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==b1/*������ư*/) {
			int i = list.getSelectedIndex();
			MemberBean bean = vlist.get(i);
			list.removeAll();
			remove(list);
			updateForm(bean);
		}else if(obj==b2/*������ư*/) {
			int i = list.getSelectedIndex();
			MemberBean bean = vlist.get(i);
			if(mgr.deleteMember(bean.getNum())) {
				p3.removeAll();
				remove(p3);
				list.removeAll();
				remove(list);
				vlist.removeAllElements();
				viewList();
			}
		}else if(obj==b3/*�Է¹�ư*/) {
			p3.removeAll();
			list.removeAll();
			remove(list);
			insertForm();
		}else if(obj==b4/*����Ʈ��ư*/) {
			p3.removeAll();
			remove(p3);
			list.removeAll();
			remove(list);
			vlist.removeAllElements();
			viewList();
		}else if(obj==zipBtn) {
			if(zf==null)
				zf = new ZipcodeFrame(this);
			else
				zf.setVisible(true);
		}else if(obj==insBtn/*�Է�����*/) {
			MemberBean bean = new MemberBean();
			bean.setName(tf1.getText());
			bean.setPhone(tf2.getText());
			bean.setTeam(tf3.getText());
			bean.setAddress(tf4.getText());
			if(mgr.insertMember(bean)) {
				p3.removeAll();
				remove(p3);
				vlist.removeAllElements();
				viewList();
			}
				
		}else if(obj==upBtn/*��������*/) {
			MemberBean bean = new MemberBean();
			bean.setNum(num);
			bean.setName(tf1.getText());
			bean.setPhone(tf2.getText());
			bean.setTeam(tf3.getText());
			bean.setAddress(tf4.getText());
			if(mgr.updateMembe(bean)) {
				p3.removeAll();
				remove(p3);
				vlist.removeAllElements();
				viewList();
			}
		}
		validate();
	}//--actionPerformed

	public static void main(String[] args) {
		new MemberAWT();
	}
}
