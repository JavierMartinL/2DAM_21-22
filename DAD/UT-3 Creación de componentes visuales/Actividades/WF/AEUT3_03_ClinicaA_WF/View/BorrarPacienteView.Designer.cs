
namespace View
{
    partial class BorrarPacienteView
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.ltvPacientes = new System.Windows.Forms.ListView();
            this.colNHC = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.colDNI = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.colNombre = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.colApellidos = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.colDireccion = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.colPoblacion = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.btnBuscar = new System.Windows.Forms.Button();
            this.txbValor = new System.Windows.Forms.TextBox();
            this.lblValor = new System.Windows.Forms.Label();
            this.cbxSeleccion = new System.Windows.Forms.ComboBox();
            this.SuspendLayout();
            // 
            // ltvPacientes
            // 
            this.ltvPacientes.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.colNHC,
            this.colDNI,
            this.colNombre,
            this.colApellidos,
            this.colDireccion,
            this.colPoblacion});
            this.ltvPacientes.FullRowSelect = true;
            this.ltvPacientes.HideSelection = false;
            this.ltvPacientes.Location = new System.Drawing.Point(44, 109);
            this.ltvPacientes.Name = "ltvPacientes";
            this.ltvPacientes.Size = new System.Drawing.Size(712, 311);
            this.ltvPacientes.TabIndex = 24;
            this.ltvPacientes.UseCompatibleStateImageBehavior = false;
            this.ltvPacientes.View = System.Windows.Forms.View.Details;
            this.ltvPacientes.MouseClick += new System.Windows.Forms.MouseEventHandler(this.eliminarPaciente);
            // 
            // colNHC
            // 
            this.colNHC.Text = "NHC";
            this.colNHC.Width = 38;
            // 
            // colDNI
            // 
            this.colDNI.Text = "DNI";
            this.colDNI.Width = 81;
            // 
            // colNombre
            // 
            this.colNombre.Text = "Nombre";
            this.colNombre.Width = 110;
            // 
            // colApellidos
            // 
            this.colApellidos.Text = "Apellidos";
            this.colApellidos.Width = 136;
            // 
            // colDireccion
            // 
            this.colDireccion.Text = "Direccion";
            this.colDireccion.Width = 239;
            // 
            // colPoblacion
            // 
            this.colPoblacion.Text = "Población";
            this.colPoblacion.Width = 187;
            // 
            // btnBuscar
            // 
            this.btnBuscar.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnBuscar.Location = new System.Drawing.Point(593, 53);
            this.btnBuscar.Name = "btnBuscar";
            this.btnBuscar.Size = new System.Drawing.Size(101, 28);
            this.btnBuscar.TabIndex = 23;
            this.btnBuscar.Text = "Buscar";
            this.btnBuscar.UseVisualStyleBackColor = true;
            this.btnBuscar.Click += new System.EventHandler(this.buscarPacientes);
            // 
            // txbValor
            // 
            this.txbValor.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txbValor.Location = new System.Drawing.Point(44, 55);
            this.txbValor.Name = "txbValor";
            this.txbValor.Size = new System.Drawing.Size(161, 26);
            this.txbValor.TabIndex = 22;
            // 
            // lblValor
            // 
            this.lblValor.AutoSize = true;
            this.lblValor.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblValor.Location = new System.Drawing.Point(47, 31);
            this.lblValor.Name = "lblValor";
            this.lblValor.Size = new System.Drawing.Size(82, 20);
            this.lblValor.TabIndex = 20;
            this.lblValor.Text = "Busqueda";
            // 
            // cbxSeleccion
            // 
            this.cbxSeleccion.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbxSeleccion.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cbxSeleccion.FormattingEnabled = true;
            this.cbxSeleccion.Items.AddRange(new object[] {
            "NHC",
            "DNI"});
            this.cbxSeleccion.Location = new System.Drawing.Point(283, 53);
            this.cbxSeleccion.Name = "cbxSeleccion";
            this.cbxSeleccion.Size = new System.Drawing.Size(121, 28);
            this.cbxSeleccion.TabIndex = 25;
            // 
            // BorrarPacienteView
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.cbxSeleccion);
            this.Controls.Add(this.ltvPacientes);
            this.Controls.Add(this.btnBuscar);
            this.Controls.Add(this.txbValor);
            this.Controls.Add(this.lblValor);
            this.Name = "BorrarPacienteView";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Borrar Paciente";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListView ltvPacientes;
        private System.Windows.Forms.ColumnHeader colNHC;
        private System.Windows.Forms.ColumnHeader colDNI;
        private System.Windows.Forms.ColumnHeader colNombre;
        private System.Windows.Forms.ColumnHeader colApellidos;
        private System.Windows.Forms.ColumnHeader colDireccion;
        private System.Windows.Forms.ColumnHeader colPoblacion;
        private System.Windows.Forms.Button btnBuscar;
        private System.Windows.Forms.TextBox txbValor;
        private System.Windows.Forms.Label lblValor;
        private System.Windows.Forms.ComboBox cbxSeleccion;
    }
}