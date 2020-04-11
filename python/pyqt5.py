import sys
from PyQt5.QtWidgets import *
from PyQt5.QtCore import Qt

class MyWindow(QMainWindow):
    def __init__(self):
        super().__init__()

    # 레이아웃 실습
    # def makeUI(self):
    #     myLabel1 = QLabel('My Label1')
    #     myLabel2 = QLabel('My Label2')
    #     myLabel3 = QLabel('My Label3')

    #     hBoxLayout = QHBoxLayout()
    #     hBoxLayout.addStretch(2)
    #     hBoxLayout.addWidget(myLabel1)
    #     hBoxLayout.addWidget(myLabel2)

    #     vBoxLayout = QVBoxLayout()
    #     vBoxLayout.addLayout(hBoxLayout)
    #     vBoxLayout.addWidget(myLabel3)
        
    #     win = QWidget()
    #     win.setLayout(vBoxLayout)
    #     self.setCentralWidget(win)
    #     self.setGeometry(100,200,300,400)
    #     self.setWindowTitle('MyWindow')
    #     self.show()

    def makeUI(self):
        myLabel1 = QLabel('Please, select button!')
        
        btn1 = QPushButton('Button 01')
        btn1.clicked.connect(btn1ClickListener)
        btn2 = QPushButton('Button 02')
        btn2.clicked.connect(btn1ClickListener)
        btn2.clicked.connect(btn2ClickListener)

        lineEdit1 = QLineEdit()

        slider1 = QSlider(Qt.Horizontal, self)
        slider1.setMinimum(0)
        slider1.setMaximum(100)
        slider1.valueChanged[int].connect(slider1ChangeListener)

        hBoxLayout = QHBoxLayout()
        hBoxLayout.addWidget(btn1)
        hBoxLayout.addWidget(btn2)

        vBoxLayout = QVBoxLayout()
        vBoxLayout.addWidget(myLabel1)
        vBoxLayout.addLayout(hBoxLayout)
        vBoxLayout.addWidget(lineEdit1)
        vBoxLayout.addWidget(slider1)
        vBoxLayout.addStretch()
        
        win = QWidget()
        win.setLayout(vBoxLayout)
        self.setCentralWidget(win)
        self.setGeometry(100,200,300,400)
        self.setWindowTitle('MyWindow')
        self.show()

def btn1ClickListener():
    print("btn1")

def btn2ClickListener():
    print("btn2")

def slider1ChangeListener(value):
    print("Slider 01 changed! : {0}".format(value))

app = QApplication(sys.argv)
myWin = MyWindow()
myWin.makeUI()
sys.exit(app.exec())