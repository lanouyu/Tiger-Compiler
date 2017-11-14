# Tiger-Compiler
Complement Tiger compiler in Java

本次课程设计实验是为tiger语言设计并实现一个编译器，利用虎书官网所提供的项目框架完成词法分析与语法分析（抽象语法树），并将语义分析，活动记录，中间代码生成，规范化，指令选择，活性分析和寄存器分配作为扩展内容。

实验步骤：
* 通过词法分析将源文件分解为独立的单词符号；
* 通过语法分析分析程序的短语结构；
* 通过语义动作对每个短语建立对应的抽象语法树；
* 通过语义分析确定每个短语的含义，建立变量及其声明的关联，检查表达式类型；
* 通过栈帧布局按机器要求的方式将变量、函数参数等分配于活动记录内；
* 通过翻译生成与目标机器无关的中间表示树（IR树）；
* 通过规范化提取表达式中的副作用，整理条件分支；
* 通过指令选择将IR树结点组合成与目标指令相对应的块；
* 通过控制流分析建立控制流图；
* 通过数据流分析收集程序变量的数据流信息；
* 通过寄存器分配为程序中的每一个变量和临时数据选择一个寄存器；
* 通过代码流出用机器寄存器替代机器指令中的临时变量名；
