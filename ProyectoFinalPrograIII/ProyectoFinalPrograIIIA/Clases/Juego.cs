using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ProyectoFinalPrograIIIA.Clases
{
    internal class Juego
    {

        private string nombreJuego { get; set; }
        private int alturaPantalla { get; set; }
        private int anchoPantalla { get; set; }
        private int punteo { get; set; }
        private int velocidad { get; set; }


        enum Direccion
        {
            ARRIBA,ABAJO,IZQUIERDA,DERECHA
        }

        public Juego()
        {
            this.nombreJuego = "Juego de la Culebrita";
            this.alturaPantalla = 20;
            this.anchoPantalla = 60;
            this.punteo = 0;
            this.velocidad = 100; // 100 milisegundos = 0.1s
        }


        public void run()
        {
            var foodPosition = Point.Empty;
            var culebrita = new Culebrita();
            var longitudCulebrita = 3;
            var actualPosicion = new Point(0, 9);
            var direccion = Direccion.DERECHA;

            culebrita.EnQueue(actualPosicion);
            DibujaPantalla();

            while (moverCulebrita(culebrita, actualPosicion, longitudCulebrita))
            {
                Thread.Sleep(this.velocidad);
                direccion = GetDireccion(direccion);
                actualPosicion = ObtenerSiguienteDireccion(direccion, actualPosicion);
            }

            Console.ResetColor();
            Console.SetCursorPosition(this.anchoPantalla / 2 - 4, this.alturaPantalla / 2);
            Console.Write("Haz fallado.");
            Thread.Sleep(2000);
            Console.ReadKey();
        }


        /// <summary>
        /// Este método crea el tablero o la pantalla en dónde se movera el Snake.
        /// Establece primero todo el fondo blanco, y posteriormente pinta el fondo negro, dejando un marco de color blanco.
        /// </summary>
        void DibujaPantalla()
        {
            Console.Title = this.nombreJuego;

            Console.WindowHeight = this.alturaPantalla + 2;
            Console.WindowWidth = this.anchoPantalla + 2;

            Console.BufferHeight = Console.WindowHeight;
            Console.BufferWidth = Console.WindowWidth;

            Console.CursorVisible = false;
            Console.BackgroundColor = ConsoleColor.White;

            Console.Clear();

            Console.BackgroundColor = ConsoleColor.Black;
            for (int row = 0; row < this.alturaPantalla; row++)
            {
                for (int col = 0; col < this.anchoPantalla; col++)
                {
                    Console.SetCursorPosition(col + 1, row + 1);
                    Console.Write(" ");
                }
            }


            MuestraPunteo();
        }

        /// <summary>
        /// Muestra el punteo en pantalla actual del juego
        /// </summary>
        void MuestraPunteo()
        {
            Console.BackgroundColor = ConsoleColor.White;
            Console.ForegroundColor = ConsoleColor.Green;

            Console.SetCursorPosition(1, 0);

            Console.Write($"Punteo: {this.punteo.ToString("00000000")}");
        }

        /// <summary>
        /// Verifica si hemos pulsado alguna tecla, y define la dirección en la que se moverá la serpiente
        /// </summary>
        /// <param name="direccionActual">Direccion en la que se mueve la serpiente</param>
        /// <returns>Dirección en la que serpiente se moverá</returns>
        Direccion GetDireccion(Direccion direccionActual)
        {
            if (!Console.KeyAvailable) return direccionActual;

            var key = Console.ReadKey(true).Key;

            switch (key)
            {
                case ConsoleKey.DownArrow:
                    if (direccionActual != Direccion.ARRIBA)
                        direccionActual = Direccion.ABAJO;
                    break;
                case ConsoleKey.LeftArrow:
                    if (direccionActual != Direccion.DERECHA)
                        direccionActual = Direccion.IZQUIERDA;
                    break;
                case ConsoleKey.RightArrow:
                    if (direccionActual != Direccion.IZQUIERDA)
                        direccionActual = Direccion.DERECHA;
                    break;
                case ConsoleKey.UpArrow:
                    if (direccionActual != Direccion.ABAJO)
                        direccionActual = Direccion.ARRIBA;
                    break;
            }

            return direccionActual;
        }

        // Retorna la nueva posición en la que deberá moverse el snake

        Point ObtenerSiguienteDireccion(Direccion direccion, Point posicionActual)
        {
            Point siguientePosicion = new Point(posicionActual.X, posicionActual.Y);

            switch (direccion)
            {
                case Direccion.ARRIBA:
                    siguientePosicion.Y--;
                    break;
                case Direccion.IZQUIERDA:
                    siguientePosicion.X--;
                    break;
                case Direccion.ABAJO:
                    siguientePosicion.Y++;
                    break;
                case Direccion.DERECHA:
                    siguientePosicion.X++;
                    break;
            }

            return siguientePosicion;
        }

        bool moverCulebrita(Culebrita snake, Point targetPosition, int snakeLength)
        {
            var lastPoint = (Point)snake.colaLista.Last();
            if (lastPoint.Equals(targetPosition)) return true;

            if (snake.colaLista.Any(x => x.Equals(targetPosition))) return true;

            if (targetPosition.X < 0 || targetPosition.X >= this.anchoPantalla || targetPosition.Y < 0
                || targetPosition.Y >= this.alturaPantalla)
            {
                return false;
            };


            Console.BackgroundColor = ConsoleColor.Green;
            Console.SetCursorPosition(lastPoint.X + 1, lastPoint.Y + 1);
            Console.Write(" ");

            snake.EnQueue(targetPosition);

            Console.BackgroundColor = ConsoleColor.Red;
            Console.SetCursorPosition(targetPosition.X + 1, targetPosition.Y + 1);
            Console.Write(" ");

            //Quitamos la cola
            if (snake.colaLista.Count() > snakeLength)
            {
                var removePoint = (Point)snake.DeQueue();
                Console.BackgroundColor = ConsoleColor.Black;
                Console.SetCursorPosition(removePoint.X + 1, removePoint.Y + 1);
                Console.Write(" ");
            }

            return true;
        }
    }
}
