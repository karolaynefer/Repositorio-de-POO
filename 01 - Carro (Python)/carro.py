class car:
	def __init__ (self):
		self.passageiro=0
		self.km=0
		self.tanque=0
		self.lim_pas=2
		self.lim_gas=10
		
	def __str__(self):
		return "pass:" + str(self.passageiro) + " gas:" + str(self.tanque) + " km: " + str(self.km)
	
	def entrar (self):
		if self.passageiro < self.lim_pas :
			self.passageiro += 1
		else:
			print("limite de pessoas atingido ")
			
	def sair (self):
		if self.passageiro > 0:
			self.passageiro -= 1
		else:
			print ("não há ninguem no carro ")
			
	def encher (self,qtd):
		 self.tanque += qtd 
		 if self.lim_gas < self.tanque:
			 self.tanque = self.lim_gas
			 
	def andar (self,distancia):
		gasolina_nece = distancia / 10
			
		if (self.tanque >= gasolina_nece):
			self.km += distancia
			self.tanque -= gasolina_nece								
		else:
			print(" gasolina insuficiente")
            
 #menu			
carro=car()
digitar= ""
print ("1- entrar\n2- descer\n3- mostrar\n4- encher e qtd \n5- andar e dist\n6- sair do programa\n")
while (digitar != 'sair') :
	digitar= input("digite: ")
	op= digitar.split(" ")
	
	
	if op[0] == 'sair':
		break 
	if op[0] == 'entrar':
		carro.entrar()
	if op[0] == 'descer':
		carro.sair()
	if op[0] == 'mostrar':
		print(carro)
	if op[0] == 'encher':
		carro.encher(int(op[1]))
	if op[0] == 'andar':
		if carro.passageiro == 0:
			print ("nao há ninguem no carro")
		else:
			carro.andar(int(op[1]))
