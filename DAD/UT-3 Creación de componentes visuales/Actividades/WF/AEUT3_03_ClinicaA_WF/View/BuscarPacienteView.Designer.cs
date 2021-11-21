
namespace View
{
    partial class BuscarPacienteView
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
            this.btnBuscar = new System.Windows.Forms.Button();
            this.txbNhc = new System.Windows.Forms.TextBox();
            this.txbDni = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.colNHC = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.colDNI = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.colNombre = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.colApellidos = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.colDireccion = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.colPoblacion = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.ltvPacientes = new System.Windows.Forms.ListView();
            this.SuspendLayout();
            // 
            // btnBuscar
            // 
            this.btnBuscar.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnBuscar.Location = new System.Drawing.Point(594, 51);
            this.btnBuscar.Name = "btnBuscar";
            this.btnBuscar.Size = new System.Drawing.Size(101, 28);
            this.btnBuscar.TabIndex = 17;
            this.btnBuscar.Text = "Buscar";
            this.btnBuscar.UseVisualStyleBackColor = true;
            this.btnBuscar.Click += new System.EventHandler(this.buscarPaciente);
            // 
            // txbNhc
            // 
            this.txbNhc.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txbNhc.Location = new System.Drawing.Point(45, 53);
            this.txbNhc.Name = "txbNhc";
            this.txbNhc.Size = new System.Drawing.Size(161, 26);
            this.txbNhc.TabIndex = 16;
            // 
            // txbDni
            // 
            this.txbDni.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txbDni.Location = new System.Drawing.Point(248, 53);
            this.txbDni.Name = "txbDni";
            this.txbDni.Size = new System.Drawing.Size(192, 26);
            this.txbDni.TabIndex = 15;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(48, 29);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(43, 20);
            this.label2.TabIndex = 14;
            this.label2.Text = "NHC";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(251, 29);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(37, 20);
            this.label1.TabIndex = 13;
            this.label1.Text = "DNI";
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
            // ltvPacientes
            // 
            this.ltvPacientes.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.colNHC,
            this.colDNI,
            this.colNombre,
            this.colApellidos,
            this.colDireccion,
            this.colPoblacion});
            this.ltvPacientes.HideSelection = false;
            this.ltvPacientes.Location = new System.Drawing.Point(45, 107);
            this.ltvPacientes.Name = "ltvPacientes";
            this.ltvPacientes.Size = new System.Drawing.Size(712, 311);
            this.ltvPacientes.TabIndex = 18;
            this.ltvPacientes.UseCompatibleStateImageBehavior = false;
            this.ltvPacientes.View = System.Windows.Forms.View.Details;
            // 
            // BuscarPacienteView
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.ltvPacientes);
            this.Controls.Add(this.btnBuscar);
            this.Controls.Add(this.txbNhc);
            this.Controls.Add(this.txbDni);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "BuscarPacienteView";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Buscar Pacientes";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnBuscar;
        private System.Windows.Forms.TextBox txbNhc;
        private System.Windows.Forms.TextBox txbDni;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ColumnHeader colNHC;
        private System.Windows.Forms.ColumnHeader colDNI;
        private System.Windows.Forms.ColumnHeader colNombre;
        private System.Windows.Forms.ColumnHeader colApellidos;
        private System.Windows.Forms.ColumnHeader colDireccion;
        private System.Windows.Forms.ColumnHeader colPoblacion;
        private System.Windows.Forms.ListView ltvPacientes;
    }
}