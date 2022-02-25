class Nodo:

    # Constructor
    def __init__(self, valor, izdo=None, dcho=None):
        self.dato = valor
        self.izdo = izdo
        self.dcho = dcho

    # Operacions de Acceso

    # Devuelve el Valor del Nodo
    def ValorNodo(self):
        return self.dato

    # Selecciona el Valor Izquierdo
    def getSubarbolIzdo(self):
        return self.izdo

    # Selecciona el Valor Derecho
    def getSubarbolDcho(self):
        return self.dcho

    # Nuevo Valor de Nodo
    def NuevoValor(self, d):
        self.dato = d

    # Coloca el Nodo en la Rama Izquierda
    def setRamaIzdo(self, n):
        self.izdo = n

    # Coloca el Nodo en la Rama Derecha
    def setRamaDcho(self, n):
        self.dcho = n
