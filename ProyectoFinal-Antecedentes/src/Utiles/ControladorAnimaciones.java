/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Cris2
 */
public class ControladorAnimaciones {

    public void animacionPanelMenu(JPanel panel, JLabel boton) {
        if (panel.getSize().width == 230) {
            panel.setSize(230, 600);
            boton.setLocation(230, 35);
            Timer timer;
            timer = new Timer();
            TimerTask task = new TimerTask() {
                int tic = 230;
                int cont = 770;

                @Override
                public void run() {
                    panel.setSize(tic, 600);
                    boton.setLocation(tic, 35);
                    if (tic == 0) {
                        System.out.println("tic: " + tic + " cont: " + cont);
                        boolean cancel = cancel();
                    }
                    cont++;
                    tic--;

                }
            };
            // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
            timer.schedule(task, 1, 1);
        } else if (panel.getSize().getWidth() == 0) {
            panel.setSize(0, 600);
            boton.setLocation(0, 35);
            Timer timer;
            timer = new Timer();
            TimerTask task = new TimerTask() {
                int tic = 0;
                int cont = 1000;

                @Override
                public void run() {
                    panel.setSize(tic, 600);
                    boton.setLocation(tic, 35);
                    if (tic == 230) {
                        System.out.println("tic: " + tic + " cont: " + cont);
                        boolean cancel = cancel();
                    }
                    cont--;
                    tic++;

                }
            };
            // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
            timer.schedule(task, 1, 1);

        }

    }
//210 max original

    public void animacionItems(JPanel item1, JPanel conten, JLabel visto, int heighmax, int heightmin, int time, int contraer) {
        if (contraer == 1) {
            if (conten.getSize().height == heighmax) {
                item1.setOpaque(true);
                conten.setSize(260, heighmax);
                visto.setText("◄");
                Timer timer;
                timer = new Timer();
                TimerTask task = new TimerTask() {
                    int tic = heighmax;
                    int cont = 0;

                    @Override
                    public void run() {
                        conten.setSize(260, tic);
                        if (tic == heightmin) {
                            System.out.println("tic: " + tic);
                            boolean cancel = cancel();

                        }
                        tic--;

                    }
                };
                // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
                timer.schedule(task, time, time);
            }
        } else {
            if (conten.getSize().height == heighmax) {
                item1.setOpaque(true);
                conten.setSize(260, heighmax);
                visto.setText("◄");
                Timer timer;
                timer = new Timer();
                TimerTask task = new TimerTask() {
                    int tic = heighmax;
                    int cont = 0;

                    @Override
                    public void run() {
                        conten.setSize(260, tic);
                        if (tic == heightmin) {
                            System.out.println("tic: " + tic);
                            boolean cancel = cancel();

                        }
                        tic--;

                    }
                };
                // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
                timer.schedule(task, time, time);
            } else if (conten.getSize().height == heightmin) {
                item1.setOpaque(false);
                conten.setBackground(new Color(25,51,89));
                conten.setSize(260, heightmin);
                visto.setText("▼");
                Timer timer;
                timer = new Timer();
                TimerTask task = new TimerTask() {
                    int tic = heightmin;
                    int cont = 0;

                    @Override
                    public void run() {
                        conten.setSize(260, tic);
                        conten.repaint();
                        if (tic == heighmax) {
                            System.out.println("tic: " + tic);
                            boolean cancel = cancel();

                        }
                        tic++;

                    }
                };
                // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
                timer.schedule(task, time, time);

            }
        }

    }

    public void animacionItemsLocalizacion(JPanel conten, int posicion1, int posicion2, int time, int contraer) {
        System.out.println("Entra por este retardo===================================" + posicion1 + "  " + posicion2 + " " + conten.getLocation().y);
        if (conten.getLocation().y == posicion2) {
            System.out.println("ento o no entro=============");
            conten.setLocation(0, posicion2);
            Timer timer;
            timer = new Timer();
            TimerTask task = new TimerTask() {
                int tic = posicion2;
                int cont = 0;

                @Override
                public void run() {
                    conten.setLocation(0, tic);
                    System.out.println("ento o no entro=============" + tic);
                    if (tic == posicion1) {
                        System.out.println("tic location: " + tic);
                        boolean cancel = cancel();

                    }
                    tic--;

                }
            };
            // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
            timer.schedule(task, time, time);
        } else if (conten.getLocation().y == posicion1) {
            conten.setLocation(0, posicion1);
            Timer timer;
            timer = new Timer();
            TimerTask task = new TimerTask() {
                int tic = posicion1;
                int cont = 0;

                @Override
                public void run() {
                    conten.setLocation(0, tic);
                    conten.repaint();
                    if (tic == posicion2) {
                        System.out.println("tic: " + tic);
                        boolean cancel = cancel();

                    }
                    tic++;

                }
            };
            // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
            timer.schedule(task, time, time);

        }
    }

    public void colorColapse(JPanel item) {
        Color color = item.getBackground();
        Timer timer;
        item.setOpaque(true);
        timer = new Timer();
        TimerTask task = new TimerTask() {
            int tic = 255;
            int cont = 0;

            @Override
            public void run() {
                item.setBackground(new Color(tic, 105, 105));

                if (tic == 70) {
                    item.setOpaque(false);
                    item.setBackground(color);
                    boolean cancel = cancel();
                }
                tic--;

            }
        };
        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
        timer.schedule(task, 1, 1);
    }
     public boolean retardo(int time) {
        Timer timer;
        timer = new Timer();
        int co=0;
        TimerTask task;
        task = new TimerTask() {
            int tic =0;
            int cantidad=100;
            @Override
            public void run() {
                if (tic == cantidad) {
                    boolean cancel = cancel();  
                }
                tic++;
            }
        };
        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
        timer.schedule(task, time, time);
        return true;
    }
    public void animacionScroll(JScrollPane scroll, int posicion1, int posicion2, int time) {
        // scroll.getVerticalScrollBar().setValue(100);
       
        if (scroll.getVerticalScrollBar().getValue() <posicion2) {
            //scroll.getVerticalScrollBar().setValue(posicion1);
            Timer timer;
            timer = new Timer();
            TimerTask task = new TimerTask() {
                int tic = posicion1;
                int cont = 0;

                @Override
                public void run() {
                    scroll.getVerticalScrollBar().setValue(tic);
                    scroll.updateUI();
                    scroll.repaint();
                    if (tic == posicion2) {
                        System.out.println("tic: " + tic);
                        boolean cancel = cancel();
                    }
                    tic++;

                }
            };
            // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
            timer.schedule(task, time, time);

        }
    }
}
