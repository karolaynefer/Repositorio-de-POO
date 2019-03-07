class cal:
	def __init__(self, batMax):
		self.carga=0
		self.bat_max=batMax
		
	def soma (self,v1,v2):
			soma= (v1+ v2)
			return soma	
		
	def divisao (self,v1,v2):
			if v2 == 0:
				print ("ERRO")
			divisao=(v1/v2)
			return divisao
			
	
	def recarregar (self,qtd):
		self.carga += qtd
		if self.carga >	self.bat_max:
			self.carga = self.bat_max
			
	def __str__(self):
		return "bateria:" + str(self.carga) + "/" + str(self.bat_max)
	
	def bateria_vazia(self):
		if self.carga == 0:
			return False 
		else:
			return True
		
	def bat_energia(self):
		self.carga -= 1
#menu

calculadora=cal(0)

print("01 - Iniciar\n02 - Mostrar\n03 - Carregar_valor \n04 - Somar_a_b\n05 - Dividir_a_b\n06 - Sair ")
digitar= ""

while(digitar != 'sair'):
	digitar= input("")
	op= digitar.split(" ")
	
	if(op[0] == 'iniciar'):
		calculadora=cal(int(op[1]))
	if (op[0] == "sair"):
		break
		
	if(op[0] == 'mostrar'):
		print(calculadora)
		
	if(op[0]== 'carregar'):
		calculadora.recarregar(int(op[1]))
		
	if(op[0] == 'somar'):
		if(calculadora.bateria_vazia() == 'false'):
			print("Nao ha Energia")
		else:
			calculadora.bat_energia()
			print(calculadora.soma(int(op[1]),(int(op[2]))))
				
	if(op[0] == 'dividir'):
		if(calculadora.bateria_vazia() == 'false'):
			print("Nao ha Energia")
		else:
			calculadora.bat_energia()
			print(calculadora.divisao(int(op[1]),(int(op[2]))))
