
namespace View
{
    partial class AdministrativoView
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
            this.components = new System.ComponentModel.Container();
            this.tlsPaciente = new System.Windows.Forms.ToolStrip();
            this.tlsBuscarPaciente = new System.Windows.Forms.ToolStripButton();
            this.tlsCrearPaciente = new System.Windows.Forms.ToolStripButton();
            this.tlsEliminarPaciente = new System.Windows.Forms.ToolStripButton();
            this.tlsVerFichaPaciente = new System.Windows.Forms.ToolStripButton();
            this.tlsSacarEtiquetasPaciente = new System.Windows.Forms.ToolStripButton();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.tsmiPacientesMenu = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmicentroDeDíaMenu = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmicitaMenu = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiguardarActividadMenu = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmisalirMenu = new System.Windows.Forms.ToolStripMenuItem();
            this.tlsPaciente.SuspendLayout();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // tlsPaciente
            // 
            this.tlsPaciente.ImageScalingSize = new System.Drawing.Size(25, 25);
            this.tlsPaciente.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tlsBuscarPaciente,
            this.tlsCrearPaciente,
            this.tlsEliminarPaciente,
            this.tlsVerFichaPaciente,
            this.tlsSacarEtiquetasPaciente});
            this.tlsPaciente.LayoutStyle = System.Windows.Forms.ToolStripLayoutStyle.HorizontalStackWithOverflow;
            this.tlsPaciente.Location = new System.Drawing.Point(0, 28);
            this.tlsPaciente.Name = "tlsPaciente";
            this.tlsPaciente.Size = new System.Drawing.Size(600, 32);
            this.tlsPaciente.TabIndex = 0;
            this.tlsPaciente.Text = "toolStrip1";
            // 
            // tlsBuscarPaciente
            // 
            this.tlsBuscarPaciente.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.tlsBuscarPaciente.Image = global::View.Properties.Resources._011_usuario_1;
            this.tlsBuscarPaciente.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tlsBuscarPaciente.Name = "tlsBuscarPaciente";
            this.tlsBuscarPaciente.Size = new System.Drawing.Size(29, 29);
            this.tlsBuscarPaciente.Text = "Buscar paciente";
            this.tlsBuscarPaciente.Click += new System.EventHandler(this.buscarPaciente);
            // 
            // tlsCrearPaciente
            // 
            this.tlsCrearPaciente.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.tlsCrearPaciente.Image = global::View.Properties.Resources._010_usuario_2;
            this.tlsCrearPaciente.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tlsCrearPaciente.Name = "tlsCrearPaciente";
            this.tlsCrearPaciente.Size = new System.Drawing.Size(29, 29);
            this.tlsCrearPaciente.Text = "Crear paciente";
            this.tlsCrearPaciente.Click += new System.EventHandler(this.crearPaciente);
            // 
            // tlsEliminarPaciente
            // 
            this.tlsEliminarPaciente.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.tlsEliminarPaciente.Image = global::View.Properties.Resources._012_usuario;
            this.tlsEliminarPaciente.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tlsEliminarPaciente.Name = "tlsEliminarPaciente";
            this.tlsEliminarPaciente.Size = new System.Drawing.Size(29, 29);
            this.tlsEliminarPaciente.Text = "Eliminar paciente";
            this.tlsEliminarPaciente.Click += new System.EventHandler(this.eliminarPaciente);
            // 
            // tlsVerFichaPaciente
            // 
            this.tlsVerFichaPaciente.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.tlsVerFichaPaciente.Image = global::View.Properties.Resources._004_perfil;
            this.tlsVerFichaPaciente.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tlsVerFichaPaciente.Name = "tlsVerFichaPaciente";
            this.tlsVerFichaPaciente.Size = new System.Drawing.Size(29, 29);
            this.tlsVerFichaPaciente.Text = "Ver ficha de paciente";
            // 
            // tlsSacarEtiquetasPaciente
            // 
            this.tlsSacarEtiquetasPaciente.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.tlsSacarEtiquetasPaciente.Image = global::View.Properties.Resources._002_etiqueta_del_precio;
            this.tlsSacarEtiquetasPaciente.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tlsSacarEtiquetasPaciente.Name = "tlsSacarEtiquetasPaciente";
            this.tlsSacarEtiquetasPaciente.Size = new System.Drawing.Size(29, 29);
            this.tlsSacarEtiquetasPaciente.Text = "Sacar etiquetas del paciente";
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(61, 4);
            // 
            // menuStrip1
            // 
            this.menuStrip1.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmiPacientesMenu,
            this.tsmicentroDeDíaMenu,
            this.tsmicitaMenu,
            this.tsmiguardarActividadMenu,
            this.tsmisalirMenu});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Padding = new System.Windows.Forms.Padding(4, 2, 0, 2);
            this.menuStrip1.Size = new System.Drawing.Size(600, 28);
            this.menuStrip1.TabIndex = 2;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // tsmiPacientesMenu
            // 
            this.tsmiPacientesMenu.Name = "tsmiPacientesMenu";
            this.tsmiPacientesMenu.Size = new System.Drawing.Size(69, 24);
            this.tsmiPacientesMenu.Text = "Pacientes";
            this.tsmiPacientesMenu.Click += new System.EventHandler(this.pacientesMenu);
            // 
            // tsmicentroDeDíaMenu
            // 
            this.tsmicentroDeDíaMenu.Name = "tsmicentroDeDíaMenu";
            this.tsmicentroDeDíaMenu.Size = new System.Drawing.Size(90, 24);
            this.tsmicentroDeDíaMenu.Text = "Centro de día";
            this.tsmicentroDeDíaMenu.Click += new System.EventHandler(this.centroDia);
            // 
            // tsmicitaMenu
            // 
            this.tsmicitaMenu.Name = "tsmicitaMenu";
            this.tsmicitaMenu.Size = new System.Drawing.Size(40, 24);
            this.tsmicitaMenu.Text = "Cita";
            this.tsmicitaMenu.Click += new System.EventHandler(this.cita);
            // 
            // tsmiguardarActividadMenu
            // 
            this.tsmiguardarActividadMenu.Name = "tsmiguardarActividadMenu";
            this.tsmiguardarActividadMenu.Size = new System.Drawing.Size(112, 24);
            this.tsmiguardarActividadMenu.Text = "Guardar actividad";
            this.tsmiguardarActividadMenu.Click += new System.EventHandler(this.guardarActividad);
            // 
            // tsmisalirMenu
            // 
            this.tsmisalirMenu.Image = global::View.Properties.Resources._001_salida;
            this.tsmisalirMenu.Name = "tsmisalirMenu";
            this.tsmisalirMenu.Size = new System.Drawing.Size(32, 24);
            this.tsmisalirMenu.Click += new System.EventHandler(this.salir);
            // 
            // AdministrativoView
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(600, 366);
            this.Controls.Add(this.tlsPaciente);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "AdministrativoView";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = " ";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.tlsPaciente.ResumeLayout(false);
            this.tlsPaciente.PerformLayout();
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ToolStrip tlsPaciente;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem tsmiPacientesMenu;
        private System.Windows.Forms.ToolStripMenuItem tsmicentroDeDíaMenu;
        private System.Windows.Forms.ToolStripMenuItem tsmicitaMenu;
        private System.Windows.Forms.ToolStripMenuItem tsmiguardarActividadMenu;
        private System.Windows.Forms.ToolStripMenuItem tsmisalirMenu;
        private System.Windows.Forms.ToolStripButton tlsBuscarPaciente;
        private System.Windows.Forms.ToolStripButton tlsCrearPaciente;
        private System.Windows.Forms.ToolStripButton tlsEliminarPaciente;
        private System.Windows.Forms.ToolStripButton tlsVerFichaPaciente;
        private System.Windows.Forms.ToolStripButton tlsSacarEtiquetasPaciente;
    }
}