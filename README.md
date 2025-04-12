# 💬 Interfaz de Envío de Mensajes en Java Swing

Una interfaz gráfica desarrollada en Java Swing que simula el comportamiento de un componente de chat o formulario de envío, con botones estilizados, entrada de texto validada, manejo de archivos adjuntos y procesamiento asíncrono en segundo plano.

---

## ✨ Características

- 🖱️ **Botón de envío personalizado** con íconos, efectos al pasar el mouse (`hover`) y validación de entrada.
- ⌨️ **Interacción por teclado**: presiona `Enter` para enviar sin hacer clic.
- 📎 **Soporte para archivos adjuntos**, con validación combinada de entrada + archivo.
- ⚙️ **Procesamiento asíncrono** con `SwingWorker`, para evitar congelar la interfaz mientras se ejecuta la lógica de envío.
- 🎨 Diseño moderno con `JTextField`, `JButton`, `ActionListener`, `MouseAdapter`, y control de enfoque y visibilidad.
- ✅ Componentes desactivables durante la operación, con reactivación automática al finalizar.

---

## 🧪 Tecnologías utilizadas

- Java 17+
- Java Swing (para GUI)
- `ActionListener` y `MouseListener`
- `SwingWorker` (procesos en segundo plano)
- `ImageIcon` para íconos personalizados en botones
- `Key Bindings` para interacciones con el teclado

---

## 🧠 Cómo funciona

1. El usuario ingresa un mensaje en el campo de texto y/o selecciona un archivo adjunto.
2. Puede presionar el botón de envío o simplemente pulsar la tecla `Enter`.
3. Se realiza una **validación de entrada**:
   - Envío permitido si hay mensaje, archivo, o ambos.
4. Se desactiva el botón para evitar envíos múltiples.
5. Se ejecuta un `SwingWorker` para procesar el envío sin bloquear la interfaz.
6. Al finalizar, se limpia el campo de entrada y se reactiva el botón.

---

## 🚀 Cómo ejecutar el proyecto

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu-usuario/tu-repo.git
   ```

2. Abre el proyecto con tu IDE favorito (VS Code, IntelliJ, NetBeans, etc.).

3. Asegúrate de tener instalado **Java 17 o superior**.

4. Compila y ejecuta la clase principal, por ejemplo:

   ```bash
   javac Main.java
   java Main
   ```

---

## 📸 Capturas de pantalla

> *(Puedes agregar capturas en una carpeta `/screenshots` y enlazarlas aquí)*

![Captura de interfaz](./screenshots/interfaz-chat.png)

---

## 🛠️ Posibles mejoras futuras

- Integración con una API REST para envío real de mensajes.
- Soporte para múltiples mensajes con historial y scroll.
- Miniaturas o previsualización de archivos adjuntos.
- Animaciones suaves con temporizadores o efectos visuales.
- Internacionalización (soporte multilenguaje).

---

## 👨‍💻 Autor

Desarrollado por **Andres Villadiego Garcia**  
Proyecto personal / académico desarrollado con fines de aprendizaje y práctica en Java Swing.

---

## 📄 Licencia

## 🛡️ Derechos de autor


Se encuentra bajo la licencia **MIT**, lo que permite su uso, modificación y distribución con la condición de que se mantenga el aviso de autoría.

No se autoriza su uso con fines comerciales sin permiso previo.
