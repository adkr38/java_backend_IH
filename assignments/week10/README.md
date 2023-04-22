**¿Usó el mismo tipo de ruta para actualizar la información del paciente y para actualizar un departamento de empleados?**

- No, destiné una ruta específica para actualizar atributos específicos, ya que si el recurso no existiera se crearía y es
  algo que no se admite con un PATCH mapping.

**¿Por qué eligió la estrategia que eligió?**

- La estrategia se basa en respetar las limitaciones de cada mapping, si se desea hacer un PUT request se modificaría
  el recurso entero si existiera si no se crearía, en caso de un PATCH request se respondería con un 400.

**¿Cuáles son las ventajas e inconvenientes de las estrategias que eligió para crear estas rutas?**

- Las ventajas son la claridad que puede tener un desarrollador a la hora de llamar la api (endpoints muy específicos)
- La desventaja principal sería crear una ruta adicional por recurso que se quiera patchear.

**¿Cuáles son los compromisos entre PUT y PATCH?**

- PUT se debe utilizar para actualizar un recurso por completo, en cambio, el propósito de PATCH es modificar atributos del recurso.
