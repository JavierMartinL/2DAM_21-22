
namespace View
{
    partial class ListarUsuariosView
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
            this.dgvUsuarios = new System.Windows.Forms.DataGridView();
            this.cmbRoles = new System.Windows.Forms.ComboBox();
            this.lblFiltrarRol = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dgvUsuarios)).BeginInit();
            this.SuspendLayout();
            // 
            // dgvUsuarios
            // 
            this.dgvUsuarios.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvUsuarios.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.dgvUsuarios.Location = new System.Drawing.Point(0, 55);
            this.dgvUsuarios.Name = "dgvUsuarios";
            this.dgvUsuarios.Size = new System.Drawing.Size(636, 291);
            this.dgvUsuarios.TabIndex = 2;
            // 
            // cmbRoles
            // 
            this.cmbRoles.DisplayMember = "Todos";
            this.cmbRoles.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cmbRoles.FormattingEnabled = true;
            this.cmbRoles.Items.AddRange(new object[] {
            "Todos",
            "Admin",
            "Teacher",
            "Student"});
            this.cmbRoles.Location = new System.Drawing.Point(164, 12);
            this.cmbRoles.Name = "cmbRoles";
            this.cmbRoles.Size = new System.Drawing.Size(121, 24);
            this.cmbRoles.TabIndex = 3;
            this.cmbRoles.Text = "Todos";
            this.cmbRoles.ValueMember = "Todos";
            this.cmbRoles.SelectedValueChanged += new System.EventHandler(this.buscarRol);
            // 
            // lblFiltrarRol
            // 
            this.lblFiltrarRol.AutoSize = true;
            this.lblFiltrarRol.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblFiltrarRol.Location = new System.Drawing.Point(12, 15);
            this.lblFiltrarRol.Name = "lblFiltrarRol";
            this.lblFiltrarRol.Size = new System.Drawing.Size(146, 16);
            this.lblFiltrarRol.TabIndex = 4;
            this.lblFiltrarRol.Text = "Filtrar usuario por el rol:";
            // 
            // ListarUsuariosView
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(636, 346);
            this.Controls.Add(this.lblFiltrarRol);
            this.Controls.Add(this.cmbRoles);
            this.Controls.Add(this.dgvUsuarios);
            this.Name = "ListarUsuariosView";
            this.Text = "Listar Usuarios";
            ((System.ComponentModel.ISupportInitialize)(this.dgvUsuarios)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dgvUsuarios;
        private System.Windows.Forms.ComboBox cmbRoles;
        private System.Windows.Forms.Label lblFiltrarRol;
    }
}