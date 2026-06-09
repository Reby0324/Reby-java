package com;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

public class DSM5TRUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JTextField nameInput;
    private JTextField ageInput;

    private JTextField statusField;
    private JTextField problemField;
    private JTextField durationField;

    private JComboBox<String> statusComboBox;
    private JComboBox<String> problemComboBox;
    private JComboBox<String> durationComboBox;

    private JTextArea out;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DSM5TRUI frame = new DSM5TRUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public DSM5TRUI() {
    	setTitle("DSM-5-TR心理健康系統");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 962, 716);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // ============================= 標題 =============================

        JLabel titleLabel = new JLabel("DSM-5-TR 心理健康自我覺察系統");
        titleLabel.setFont(new Font("微軟正黑體", Font.BOLD, 15));
        titleLabel.setBounds(344, 24, 300, 20);
        contentPane.add(titleLabel);

        JLabel timeLabel = new JLabel("系統時間：yyyy-MM-dd HH:mm:ss");
        timeLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
        timeLabel.setBounds(27, 49, 851, 20);
        contentPane.add(timeLabel);

        JLabel remindLabel = new JLabel("本系統僅供自我覺察與求助參考，不能取代醫師或心理師診斷。");
        remindLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
        remindLabel.setBounds(27, 68, 851, 20);
        contentPane.add(remindLabel);

        // ========================= 左側基本資料區 =========================

        JPanel panel = new JPanel();
        panel.setBackground(new Color(210, 210, 210));
        panel.setBounds(27, 85, 530, 241);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel basicLabel = new JLabel("基本資料");
        basicLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 10));
        basicLabel.setBounds(10, 10, 80, 15);
        panel.add(basicLabel);

        JLabel nameLabel = new JLabel("姓名：");
        nameLabel.setBounds(34, 42, 46, 15);
        panel.add(nameLabel);

        nameInput = new JTextField();
        nameInput.setBounds(90, 38, 126, 21);
        panel.add(nameInput);
        nameInput.setColumns(10);

        JLabel ageLabel = new JLabel("年齡：");
        ageLabel.setBounds(275, 39, 40, 18);
        panel.add(ageLabel);

        ageInput = new JTextField();
        ageInput.setBounds(325, 38, 136, 21);
        panel.add(ageInput);
        ageInput.setColumns(10);

        // ========================= 目前身分 =========================

        JLabel statusLabel = new JLabel("目前身分：");
        statusLabel.setBounds(30, 80, 70, 32);
        panel.add(statusLabel);

        statusField = new JTextField();
        statusField.setBounds(90, 86, 126, 21);
        panel.add(statusField);
        statusField.setColumns(10);
       

        statusComboBox = new JComboBox<>();
        statusComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "請選擇目前身分",
            "國中/高中生",
            "大專院校學生",
            "研究生",
            "全職工作者",
            "兼職工作者",
            "待業中",
            "家庭照顧者",
            "退休",
            "其他"
        }));
        statusComboBox.setBounds(237, 85, 190, 23);
        panel.add(statusComboBox);

        // ========================= 主要困擾 =========================

        JLabel problemLabel = new JLabel("主要困擾：");
        problemLabel.setBounds(30, 122, 70, 31);
        panel.add(problemLabel);

        problemField = new JTextField();
        problemField.setBounds(90, 127, 126, 21);
        panel.add(problemField);
        problemField.setColumns(10);

        problemComboBox = new JComboBox<>();
        problemComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "請選擇主要困擾",
            "情緒低落",
            "焦慮",
            "心悸胸悶",
            "睡眠困擾",
            "壓力過大",
            "創傷經驗",
            "強迫想法",
            "注意力不集中 / 衝動",
            "人際關係困擾",
            "家庭 / 伴侶關係困擾",
            "飲食或體重困擾",
            "身體不適但檢查無明顯原因",
            "物質使用 / 酒精或藥物困擾",
            "自傷或自殺想法",
            "其他"
        }));
        problemComboBox.setBounds(237, 126, 190, 23);
        panel.add(problemComboBox);

        // ========================= 持續時間 =========================

        JLabel durationLabel = new JLabel("持續時間：");
        durationLabel.setBounds(30, 168, 70, 27);
        panel.add(durationLabel);

        durationField = new JTextField();
        durationField.setBounds(90, 171, 126, 21);
        panel.add(durationField);
        durationField.setColumns(10);

        durationComboBox = new JComboBox<>();
        durationComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "請選擇持續時間",
            "少於 1 週",
            "1個月",
            "3個月",
            "6個月",
            "12個月",
            "24個月以上"
        }));
        durationComboBox.setBounds(237, 170, 190, 23);
        panel.add(durationComboBox);

        // ========================= 下拉選單同步到左邊欄位 =========================

        statusComboBox.addActionListener(e -> {
            statusField.setText(statusComboBox.getSelectedItem().toString());
        });

        problemComboBox.addActionListener(e -> {
            problemField.setText(problemComboBox.getSelectedItem().toString());
        });

        durationComboBox.addActionListener(e -> {
            durationField.setText(durationComboBox.getSelectedItem().toString());
        });

        // ========================= 右側 DSM 分類說明區 =========================

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(226, 226, 226));
        panel_1.setBounds(567, 85, 353, 241);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel dsmLabel = new JLabel("DSM分類說明");
        dsmLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 10));
        dsmLabel.setBounds(10, 10, 100, 15);
        panel_1.add(dsmLabel);

        JTextArea dsmArea = new JTextArea();
        dsmArea.setBounds(10, 35, 333, 190);
        dsmArea.setEditable(false);
        dsmArea.setLineWrap(true);
        dsmArea.setWrapStyleWord(true);
        dsmArea.setText(
            "可參考分類：\n" +
            "1. 憂鬱相關疾患\n" +
            "2. 焦慮症\n" +
            "3. 創傷與壓力相關疾患\n" +
            "4. 強迫症及相關疾患\n" +
            "5. 睡醒障礙症\n\n" +
            "提醒：本系統只做初步整理，不做正式診斷。"
        );
        panel_1.add(dsmArea);

        // ========================= 結果區 =========================

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(27, 373, 893, 290);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        out = new JTextArea();
        out.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
        out.setBounds(0, 0, 873, 118);
        out.setLineWrap(true);
        out.setWrapStyleWord(true);
        out.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(out);
        scrollPane.setBounds(0, 0, 893, 290);
        /*捲動 垂直*/scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel_2.add(scrollPane);     
                
        panel_2.add(scrollPane);
    
        
        // ========================= 開始分析按鈕 =========================

        JButton analyzeButton = new JButton("開始分析");
        analyzeButton.setBounds(27, 340, 120, 23);
        contentPane.add(analyzeButton);
        
            analyzeButton.addActionListener(e -> {

            String name = nameInput.getText();
            String ageInputText = ageInput.getText();

            String status = statusField.getText();
            String problem = problemField.getText();
            String duration = durationField.getText();

            // ========================= 防呆判斷 =========================
            
            //Empty=空的

            if (nameInput.getText().trim().isEmpty() || ageInput.getText().trim().isEmpty()) 
            {
                out.setText("要記得輸入姓名和年齡✧*｡٩(ˊᗜˋ*)و✧*");
                return;
            }
            
            //========================年齡輸入檢查=========================
            try 
            {
            	int age=Integer.parseInt(ageInputText);
            	
            
            		if(age<=0)
                   {
            		out.setText("年齡必須大於0。");
            		return;
            
                   }
           }
            catch(NumberFormatException ex) 
            {
            	out.setText("年齡請輸入數字。");
                return;
            }
                	
           //=======================================================  
            if (status.equals("請選擇目前身分"))
            {
                out.setText("請選擇目前身分");
                return;
            }

            if (problem.equals("請選擇主要困擾")) 
            {
                out.setText("請選擇主要困擾");
                return;
            }

            if (duration.equals("請選擇持續時間")) 
            {
                out.setText("請選擇持續時間");
                return;
            }                    
          //==============================================================
            
            if (status.equals("請選擇目前身分")) 
            {
                out.setText("請選擇目前身分");
                return;
            }

            if (problem.equals("請選擇主要困擾")) 
            {
                out.setText("請選擇主要困擾");
                return;
            }

            if (duration.equals("請選擇持續時間")) 
            {
                out.setText("請選擇持續時間");
                return;
            }

            // ========================= 分析結果 =========================
            String result = "";

            result += "【基本資料】\n";
            result += "姓名：" + name + "\n";
            result += "年齡：" + ageInputText + "\n";
            result += "目前身分：" + status + "\n";
            result += "主要困擾：" + problem + "\n";
            result += "持續時間：" + duration + "\n\n";

            result += "【可能相關狀況】\n";

            // ========================= 開始分析結果 =========================
            /*if (情緒低落) 
             {
             result"顯示情緒低落的說明";
             }
             else if (焦慮)
             {
             result"顯示焦慮的說明";
             } 
             else {
             result"顯示其他說明";
             }
            */
            
            if (problem.equals("情緒低落")) 
            {
                result += "你目前的困擾可能與憂鬱情緒、壓力適應困難或憂鬱相關症狀有關。\n";
                result += "若同時出現失眠、食慾改變、對事情失去興趣、自責或無望感，建議尋求身心科或心理諮商協助。\n";
            }
            else if (problem.equals("焦慮")) {
                result += "你目前的困擾可能與焦慮症狀、壓力反應或焦慮症相關狀況有關。\n";
                result += "若經常擔心、緊張、坐立不安，或影響生活與工作，建議尋求專業評估。\n";
            }
            else if (problem.equals("心悸胸悶")) {
                result += "你目前的困擾可能與焦慮、恐慌發作或身體壓力反應有關。\n";
                result += "但心悸胸悶也可能和身體疾病有關，建議先就醫排除生理因素。\n";
            }
            else if (problem.equals("睡眠困擾")) {
                result += "你目前的困擾可能與失眠、焦慮、憂鬱或生活壓力有關。\n";
                result += "若睡眠問題已影響白天精神、工作或學習，建議尋求身心科評估。\n";
            }
            else if (problem.equals("壓力過大")) {
                result += "你目前的困擾可能與壓力適應困難、焦慮或身心壓力反應有關。\n";
                result += "若壓力已造成情緒、睡眠或身體不適，建議尋求心理諮商或身心科協助。\n";
            }
            else if (problem.equals("創傷經驗")) {
                result += "你目前的困擾可能與創傷壓力反應或 PTSD 相關症狀有關。\n";
                result += "若有反覆回想、惡夢、逃避相關情境或容易驚嚇，建議尋求專業心理治療。\n";
            }
            else if (problem.equals("強迫想法")) {
                result += "你目前的困擾可能與強迫思考或強迫症相關症狀有關。\n";
                result += "若反覆檢查、清潔、確認，且明知不需要卻難以停止，建議尋求專業評估。\n";
            }
            else if (problem.equals("注意力不集中 / 衝動")) {
                result += "你目前的困擾可能與 ADHD、焦慮、憂鬱、睡眠不足或壓力有關。\n";
                result += "若注意力困難從小就存在，並長期影響學業、工作或生活，可考慮進一步評估 ADHD。\n";
            }
            else if (problem.equals("人際關係困擾")) {
                result += "你目前的困擾可能與壓力、人際互動困難、情緒調節或焦慮有關。\n";
                result += "若人際問題長期造成痛苦，建議尋求心理諮商協助。\n";
            }
            else if (problem.equals("家庭 / 伴侶關係困擾")) {
                result += "你目前的困擾可能與親密關係壓力、家庭衝突或情緒壓力有關。\n";
                result += "若衝突持續影響情緒與生活，建議尋求心理諮商、伴侶諮商或家庭諮商。\n";
            }
            else if (problem.equals("飲食或體重困擾")) {
                result += "你目前的困擾可能與飲食行為、身體意象或情緒壓力有關。\n";
                result += "若出現暴食、催吐、過度節食或強烈害怕變胖，建議尋求身心科與心理師評估。\n";
            }
            else if (problem.equals("身體不適但檢查無明顯原因")) {
                result += "你目前的困擾可能與壓力、焦慮、身心症或身體症狀相關疾患有關。\n";
                result += "建議先完成身體檢查，若無明顯生理原因，可再尋求身心科協助。\n";
            }
            else if (problem.equals("物質使用 / 酒精或藥物困擾")) {
                result += "你目前的困擾可能與物質使用、酒精或藥物依賴風險有關。\n";
                result += "若已難以控制使用量，或影響工作、學業、人際關係，建議盡快尋求醫療協助。\n";
            }
            else if (problem.equals("自傷或自殺想法")) {
                result += "這是需要立即重視的警訊。\n";
                result += "若你有自傷或自殺想法，請立即聯絡 1925 安心專線、119，或直接前往急診。\n";
            }
            else {
                result += "目前資料較不足，建議補充更多困擾內容後再進一步評估。\n";
            }

            result += "\n【持續時間提醒】\n";

            if (duration.equals("少於 1 週")) {
                result += "雖然時間較短，但若症狀強度很高，仍建議提早尋求協助。\n";
            }
            else if (duration.equals("1個月")) {
                result += "症狀已持續約 1 個月，若已影響生活、工作或人際關係，建議開始尋求協助。\n";
            }
            else if (duration.equals("3個月")) {
                result += "症狀已持續 3 個月，建議不要只靠忍耐，應考慮身心科或心理諮商。\n";
            }
            else if (duration.equals("6個月") || duration.equals("12個月") || duration.equals("24個月以上")) {
                result += "症狀已持續較長時間，建議盡快安排專業評估。\n";
            }

            result += "\n【醫療協助建議】\n";
            result += "1. 可先至身心科、精神科或心理諮商所進行初步評估。\n";
            result += "2. 若症狀影響睡眠、工作、學習或人際關係，建議不要拖延。\n";
            result += "3. 若出現自傷、自殺想法，請立即聯絡 1925 安心專線、119 或前往急診。\n";
            out.setText(result);

            });
            

            // ========================= 清除重填按鈕 =========================

            JButton clearButton = new JButton("清除重填");
            clearButton.setBounds(332, 340, 120, 23);
            contentPane.add(clearButton);

            clearButton.addActionListener(e -> {
                nameInput.setText("");
                ageInput.setText("");

                statusField.setText("");
                problemField.setText("");
                durationField.setText("");

                statusComboBox.setSelectedIndex(0);
                problemComboBox.setSelectedIndex(0);
                durationComboBox.setSelectedIndex(0);
                out.setText("");
            });

            // ========================= 關閉系統按鈕 =========================

            JButton closeButton = new JButton("關閉系統");
            closeButton.addMouseListener(new MouseAdapter() {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		System.exit(0);
            	}
            });
            closeButton.setBounds(800, 340, 120, 23);
            contentPane.add(closeButton);
            
            // ========================= 跳出儲存紀錄的視窗 =========================
            
            JButton saveButton = new JButton("儲存紀錄");
            saveButton.addMouseListener(new MouseAdapter() {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		JOptionPane.showMessageDialog(
            	    null,
            	    "已將您填寫的資料儲存到系統！可以將資料給予您的醫師與心理師參考。",
            	    "Message",JOptionPane.INFORMATION_MESSAGE);           		
            	}
            });
            saveButton.setBounds(486, 340, 120, 23);
            contentPane.add(saveButton);
                               
            //===========================列印結果==================================
            JButton print = new JButton("列印結果");
            print.addMouseListener(new MouseAdapter() {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		try
            		{
            			out.print();            			
            		}catch(PrinterException e1)
            		{
            			e1.printStackTrace();
            		}            		
            		
            	}
            });
            print.setBounds(646, 340, 120, 23);
            contentPane.add(print);
            //=======================使用說明=============================
            
            JButton useButton = new JButton("使用說明");
            useButton.addMouseListener(new MouseAdapter() {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            	JOptionPane.showMessageDialog(
            	null,	
            	"使用的步驟:"
            	+"\n1.請輸入姓名與年齡。"
            	+"\n2.請選擇目前身分、主要困擾與持續時間"
            	+"\n3按下開始分析，即可看到初步提醒。",
            	"使用說明",
            	JOptionPane.INFORMATION_MESSAGE
            	);
            	}
            });
            useButton.setBounds(177, 340, 120, 23);
            contentPane.add(useButton);

            // ========================= 系統時間 =========================

            DateTimeFormatter now = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            Timer timer = new Timer(1000, e ->timeLabel.setText("系統時間：" + LocalDateTime.now().format(now)));
            timer.start();
            
    }
}
   
