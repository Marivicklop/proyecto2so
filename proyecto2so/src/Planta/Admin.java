/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Planta;

import java.util.Random;

/**
 *
 * @author mvlop
 */
public class Admin {
    
    

    private Phones returnPhoneAdded(int trophies, int plantN) {
        
              if (trophies <= 1999) {
                int id = proyecto2so.Proyecto2so.id ++;
                Phones phone = new Phones(id, 3, trophies, plantN);
                return phone;

            } else if (trophies >= 2000 && trophies <= 3000) {
                int id = proyecto2so.Proyecto2so.id ++;
                Phones phone = new Phones(id, 2, trophies, plantN);
                return phone;

            } else {
                int id = proyecto2so.Proyecto2so.id ++;
                Phones phone = new Phones(id, 1, trophies, plantN);            
                return phone;

            
            }
              
              
    }    
 
    public void addPhone () {
        //se establecen los limites de nivel
        
        int limit = 4000;
        
        //genera el número random de copas para las tres plantas
      
        
        Random rand = new Random(); 
     
        int levelthropsP1 = rand.nextInt(limit);     
        int levelthropsP2 = rand.nextInt(limit);  
        int levelthropsP3 = rand.nextInt(limit);  
        
        if (proyecto2so.Proyecto2so.released == 0) {
              
            

                // SE AGREGA A PLANTA 1
            
                Phones phone1 = returnPhoneAdded(levelthropsP1, 1);
                proyecto2so.Proyecto2so.level1QueueP1.encolar(phone1);
                            
                // SE AGREGA A PLANTA 2
            
                Phones phone2 = returnPhoneAdded(levelthropsP2, 2);
                proyecto2so.Proyecto2so.level1QueueP2.encolar(phone2);
            
                // SE AGREGA A PLANTA 3
            
                Phones phone3 = returnPhoneAdded(levelthropsP3, 3);
                proyecto2so.Proyecto2so.level1QueueP3.encolar(phone3);

        
        } else {
            //ME FALTA ESTO AAAAAAAAAAAAAAAAAAAAAAAAAAAA
        } 
        
    }
    
    //DESENCOLA EL TELÉFONO DE LA COLA SELECCIONADA
    
    private Phones dequeuePhone(proyecto2so.Cola selectedQueue) {
        if (selectedQueue.getSize()>0) {
            Phones selected = (Phones) selectedQueue.desencolar();
            selected.resetCounter();
            return selected;
        } else {
            //NO HAY TELEFONOS EN LA COLA
            return null;
        }
    }
    
   
    public void selectPhone(int plantN) {
        switch (plantN) {
            case 1:
                {
                    Phones queue1Phone = dequeuePhone(proyecto2so.Proyecto2so.level1QueueP1);
                    Phones queue2Phone = dequeuePhone(proyecto2so.Proyecto2so.level2QueueP1);
                    Phones queue3Phone = dequeuePhone(proyecto2so.Proyecto2so.level3QueueP1);
                    if (queue1Phone == null && queue2Phone == null && queue3Phone == null) {
                        System.out.println("NO HAY TELÉFONOS A SELECCIONAR");
                    } else {
                        
                        //Aquí se puede hacer otro condicional para que dependiendo del teléfono que salga en null este no se muestre
                        //y solo se muestren los que no retornaron null
                        System.out.println("Se desencolaron los teléfonos: " + queue1Phone.id + queue2Phone.id + queue1Phone.id);
                    }
                    break;
                }
            case 2:
                {
                    Phones queue1Phone = dequeuePhone(proyecto2so.Proyecto2so.level1QueueP2);
                    Phones queue2Phone = dequeuePhone(proyecto2so.Proyecto2so.level2QueueP2);
                    Phones queue3Phone = dequeuePhone(proyecto2so.Proyecto2so.level3QueueP2);
                    if (queue1Phone == null && queue2Phone == null && queue3Phone == null) {
                        System.out.println("NO HAY TELÉFONOS A SELECCIONAR");
                    }
                    break;
                }
            case 3:
                {
                        Phones queue1Phone = dequeuePhone(proyecto2so.Proyecto2so.level1QueueP3);
                        Phones queue2Phone = dequeuePhone(proyecto2so.Proyecto2so.level2QueueP3);
                        Phones queue3Phone = dequeuePhone(proyecto2so.Proyecto2so.level3QueueP3);
                        if (queue1Phone == null && queue2Phone == null && queue3Phone == null) {
                                System.out.println("NO HAY TELÉFONOS A SELECCIONAR");
                                }
                        break;
                }
            default:
                {
                        break;
                        }
        }
    }
    
    
    
    //DEPENDIENDO DEL NIVEL DE PRIORIDAD SE ENCOLA SEGUN ESTE
    private void queueLevel(Phones phone, proyecto2so.Cola level1, proyecto2so.Cola level2, proyecto2so.Cola level3) {
        switch (phone.level) { 
            case 1:
            {
                level1.encolar(phone);
            }
            case 2:
            {
                level2.encolar(phone);
            }
            case 3:
            {
                level3.encolar(phone);
                
            }
            default: {
                    break;
                    }
        }
    }     
    
    
    
// Usado para reencolar en caso de que se tenga que encolar de nuevo un teléfono en revisión    
    public void reEnqueue(Phones phone) {
        switch (phone.plant) { 
            case 1:
            {
                queueLevel(phone, proyecto2so.Proyecto2so.level1QueueP1, proyecto2so.Proyecto2so.level2QueueP1, proyecto2so.Proyecto2so.level3QueueP1);
            }
            case 2:
            {
                queueLevel(phone, proyecto2so.Proyecto2so.level1QueueP2, proyecto2so.Proyecto2so.level2QueueP2, proyecto2so.Proyecto2so.level3QueueP2);
                
            }
            case 3:
            {
                queueLevel(phone, proyecto2so.Proyecto2so.level1QueueP3, proyecto2so.Proyecto2so.level2QueueP3, proyecto2so.Proyecto2so.level3QueueP3);
                
            }
            default: {
                    break;
                    }
        }
    }
    
    //función para encolar 
    public void enqueueReforcement(Phones phone) {
        proyecto2so.Proyecto2so.reforcementQueue.encolar(phone);
    }
    
    //funcion para que en caso de un 40% de probabilidad se desencole el primer telefono
    
    public void dequeueReforcement() {
        Random rand = new Random(); 
    
        int probability = rand.nextInt(100);     

        if (proyecto2so.Proyecto2so.reforcementQueue.getSize() > 0 && probability <= 40){
            Phones phone = (Phones) proyecto2so.Proyecto2so.reforcementQueue.desencolar();
            
            
        }
    }
    
    
    
    
    
   
    
    

    
}
