# 📦 Tarea8 - Gestión de Artículos con Java y db4o

Este proyecto consiste en una aplicación de escritorio en Java que utiliza la base de datos orientada a objetos **db4o** para almacenar, buscar, modificar y eliminar artículos.  
Cuenta con una interfaz gráfica moderna creada con `JFrame` y ventanas emergentes `JOptionPane`.

---

## 🚀 Funcionalidades principales

- 🔍 Buscar artículos por código (exacto o parcial)
- 🆕 Insertar nuevos artículos si no están duplicados
- 📝 Modificar artículos existentes
- 🗑️ Eliminar artículos de la base de datos
- 📋 Mostrar todos los artículos registrados
- 🎨 Interfaz amigable con diseño moderno en Swing

---

## 🧱 Estructura del proyecto
<pre>
Tarea8/
├── src/
│   └── tarea8/
│       ├── Articulos.java        # Clase modelo del artículo
│       ├── DbHandler.java       # Lógica de acceso a la base de datos
│       └── tarea8Frame.java     # Interfaz gráfica con JFrame
├── README.md                    # Documentación del proyecto
└── Tarea8.yap                  # Archivo de base de datos db4o
</pre>


---

## 💾 Base de datos

Se ha utilizado **db4o** como motor de base de datos embebida orientada a objetos.  
Los objetos de tipo `Articulos` se guardan directamente sin necesidad de transformar a tablas ni SQL.

---

## 🧠 Clases y métodos

### 📌 Clase `Articulos`
Contiene los atributos de cada artículo:
- `codigo`
- `nombre`
- `cantidad`
- `descripcion`

Incluye los getters y setters correspondientes.

---

### 📌 Clase `DbHandler`

Contiene todos los métodos que manejan la lógica de la base de datos:

| Método | Descripción |
|--------|-------------|
| `crearBD()` | Abre la conexión con el archivo `.yap` |
| `insertar(Articulos)` | Inserta un nuevo artículo si no está repetido |
| `buscar(String codigo)` | Busca un artículo exacto por código |
| `mostrar()` | Muestra todos los artículos guardados |
| `modificar(codigo, nombre, cantidad, descripcion)` | Modifica un artículo existente |
| `borrar(String codigo)` | Elimina un artículo por código |
| `encabezado()` | Crea el encabezado del listado |
| `buscadorEspecial(String codigo)` | Muestra artículos cuyo código contenga ese número |

---

## 🖼️ Interfaz Gráfica

- Diseñada con **`JFrame`** y `JOptionPane`
- Busca simular una experiencia moderna y clara para el usuario
- Todas las operaciones se manejan mediante cuadros de diálogo

---

## 🛠️ Tecnologías utilizadas

| Tecnología | Uso |
|------------|-----|
| Java       | Lógica principal y creación de interfaz |
| db4o       | Base de datos embebida orientada a objetos |
| Swing      | Creación de la interfaz gráfica (JFrame, JOptionPane) |

---

## ▶️ Cómo ejecutar el proyecto

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu-usuario/tarea8.git
