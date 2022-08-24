# LineEditor

## 說明
模擬行編輯器，可以用來做最基本的文本編輯，可使用的命令功能有a(add lines), i(insert lines), c(change lines), d(delete a line), p(print lines), nb(create a new buffer), cb(change buffer), q(quit)
- a(add lines)
	- 23a       :  在第23行之下add lines
	- .a        :  在「目前這一行」之下add lines
	- $a        :  在最後一行之下add lines
	- a         :  在「目前這一行」之下add lines
- i(insert lines)
	- 23i       :  在第23行之上add lines
	- .i        :  在「目前這一行」之上add lines
	- $i        :  在最後一行之上add lines
	- i         :  在「目前這一行」之上add lines
- c(change lines)
	- 23c       :  把第23行換成以下 lines
	- .c        :  把「目前這一行」換成以下 lines
	- $c        :  把最後一行換成以下 lines
	- c         :  把「目前這一行」換成以下 lines
- d(delete a line)
	- 23d       :  把第23行刪除
	- .d        :  把「目前這一行」刪除
	- $d        :  把最後一行刪除
	- d         :  把「目前這一行」刪除
- p(print lines)
	- 23p       :  把第23行印出來
	- .p        :  把「目前這一行」印出來
	- $p        :  把最後一行印出來
	- p         :  把「目前這一行」印出來
	- %p        :  把正在編輯的文章的全部內容印出來

- b(buffer)
	- b         : 把目前的「工作buffer」的名字列出來
	- b name    : 把目前的「工作buffer」的名字改為'name'
	- lb        : 把所有的buffer的名字依照buffer產生的順序列出來 (list buffers)
	- cb name   : 切換到'name'這個buffer(以'name'這個buffer作為目前的「工作buffer」) (change buffer)
	- nb name   : 產生一個新的、名叫'name'的buffer，並以它作為目前的「工作buffer」 (new buffer)
	- nb        : 產生一個新的、由系統取名的buffer，並以它作為目前的「工作buffer」 (new buffer)

- other
	- 23        :  列印第23行(含line number與內容)，同時把第23行設定為「目前這一行」
	- $         :  列印最後一行(含line number與內容)，並把最後一行設定為「目前這一行」
	- .         :  列印「目前這一行」(含line number與內容)
	- q         : 離開系統(quit)
	
	
# 程式驗證結果
