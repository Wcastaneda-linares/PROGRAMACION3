using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ProyectoFinalPrograIIIA.Clases
{
    internal class Culebrita
    {

        internal int fin { get; set; }
        internal int frente { get; set; }
        internal int tamanoQueue { get; set; }
        internal object[] colaLista { get; set; }

        public Culebrita(int QueueSize = 40)
        {
            frente = 0;
            fin = -1;
            this.tamanoQueue = QueueSize;
            colaLista = new object[this.tamanoQueue];
        }

        //Operaciones de modificar la cola

        //EnQueue = Insertar
        public void EnQueue(object point)
        {
            if (colaLlena()) throw new Exception("Cola llena");
            colaLista[++fin] = point;
        }


        //DeQueue - eliminar
        public object DeQueue()
        {
            if (colaVacia()) throw new Exception("Cola vacia");
            object aux = colaLista[frente];
            colaLista[frente] = null;
            frente++;
            return aux;
        }

        //Cola vacía
        public void borrarCola()
        {
            frente = 0;
            fin = -1;
        }

        public object frenteCola()
        {
            if (colaVacia()) throw new Exception("Cola Vacia");
            return colaLista[frente];
        }

        //Métodos de verificación de cola
        public bool colaVacia()
        {
            return frente > fin;
        }

        public bool colaLlena()
        {
            return fin == this.tamanoQueue - 1;
        }
    }
}

