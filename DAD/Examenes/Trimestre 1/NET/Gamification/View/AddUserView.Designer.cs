
namespace View
{
    partial class AddUserView
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
            this.lblUserName = new System.Windows.Forms.Label();
            this.lblPassword = new System.Windows.Forms.Label();
            this.lblRepeatPassword = new System.Windows.Forms.Label();
            this.lblRol = new System.Windows.Forms.Label();
            this.txbUserName = new System.Windows.Forms.TextBox();
            this.txbPassword = new System.Windows.Forms.TextBox();
            this.txbRepeatPassword = new System.Windows.Forms.TextBox();
            this.cmbRol = new System.Windows.Forms.ComboBox();
            this.btnAdd = new System.Windows.Forms.Button();
            this.lblErrorUserName = new System.Windows.Forms.Label();
            this.lblErrorPassword = new System.Windows.Forms.Label();
            this.lblErrorRepeatPassword = new System.Windows.Forms.Label();
            this.lblErrorRol = new System.Windows.Forms.Label();
            this.lblErrorPassworRepetidas = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // lblUserName
            // 
            this.lblUserName.AutoSize = true;
            this.lblUserName.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblUserName.Location = new System.Drawing.Point(53, 31);
            this.lblUserName.Name = "lblUserName";
            this.lblUserName.Size = new System.Drawing.Size(85, 20);
            this.lblUserName.TabIndex = 0;
            this.lblUserName.Text = "UserName";
            // 
            // lblPassword
            // 
            this.lblPassword.AutoSize = true;
            this.lblPassword.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblPassword.Location = new System.Drawing.Point(53, 88);
            this.lblPassword.Name = "lblPassword";
            this.lblPassword.Size = new System.Drawing.Size(78, 20);
            this.lblPassword.TabIndex = 1;
            this.lblPassword.Text = "Password";
            // 
            // lblRepeatPassword
            // 
            this.lblRepeatPassword.AutoSize = true;
            this.lblRepeatPassword.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblRepeatPassword.Location = new System.Drawing.Point(29, 150);
            this.lblRepeatPassword.Name = "lblRepeatPassword";
            this.lblRepeatPassword.Size = new System.Drawing.Size(135, 20);
            this.lblRepeatPassword.TabIndex = 2;
            this.lblRepeatPassword.Text = "Repeat Password";
            // 
            // lblRol
            // 
            this.lblRol.AutoSize = true;
            this.lblRol.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblRol.Location = new System.Drawing.Point(53, 213);
            this.lblRol.Name = "lblRol";
            this.lblRol.Size = new System.Drawing.Size(42, 20);
            this.lblRol.TabIndex = 3;
            this.lblRol.Text = "Role";
            // 
            // txbUserName
            // 
            this.txbUserName.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txbUserName.Location = new System.Drawing.Point(183, 31);
            this.txbUserName.Name = "txbUserName";
            this.txbUserName.Size = new System.Drawing.Size(134, 26);
            this.txbUserName.TabIndex = 4;
            // 
            // txbPassword
            // 
            this.txbPassword.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txbPassword.Location = new System.Drawing.Point(183, 90);
            this.txbPassword.Name = "txbPassword";
            this.txbPassword.PasswordChar = '*';
            this.txbPassword.Size = new System.Drawing.Size(134, 26);
            this.txbPassword.TabIndex = 5;
            // 
            // txbRepeatPassword
            // 
            this.txbRepeatPassword.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txbRepeatPassword.Location = new System.Drawing.Point(183, 150);
            this.txbRepeatPassword.Name = "txbRepeatPassword";
            this.txbRepeatPassword.PasswordChar = '*';
            this.txbRepeatPassword.Size = new System.Drawing.Size(134, 26);
            this.txbRepeatPassword.TabIndex = 6;
            // 
            // cmbRol
            // 
            this.cmbRol.DisplayMember = "           ";
            this.cmbRol.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cmbRol.FormattingEnabled = true;
            this.cmbRol.Items.AddRange(new object[] {
            "",
            "Admin",
            "Teacher",
            "Student"});
            this.cmbRol.Location = new System.Drawing.Point(183, 205);
            this.cmbRol.Name = "cmbRol";
            this.cmbRol.Size = new System.Drawing.Size(134, 28);
            this.cmbRol.TabIndex = 7;
            this.cmbRol.Text = "    ";
            this.cmbRol.ValueMember = "          ";
            // 
            // btnAdd
            // 
            this.btnAdd.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnAdd.Location = new System.Drawing.Point(304, 285);
            this.btnAdd.Name = "btnAdd";
            this.btnAdd.Size = new System.Drawing.Size(82, 29);
            this.btnAdd.TabIndex = 8;
            this.btnAdd.Text = "Add";
            this.btnAdd.UseVisualStyleBackColor = true;
            this.btnAdd.Click += new System.EventHandler(this.crearUsuario);
            // 
            // lblErrorUserName
            // 
            this.lblErrorUserName.AutoSize = true;
            this.lblErrorUserName.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblErrorUserName.ForeColor = System.Drawing.Color.Red;
            this.lblErrorUserName.Location = new System.Drawing.Point(180, 60);
            this.lblErrorUserName.Name = "lblErrorUserName";
            this.lblErrorUserName.Size = new System.Drawing.Size(144, 16);
            this.lblErrorUserName.TabIndex = 18;
            this.lblErrorUserName.Text = "Introduce el usuario";
            this.lblErrorUserName.Visible = false;
            // 
            // lblErrorPassword
            // 
            this.lblErrorPassword.AutoSize = true;
            this.lblErrorPassword.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblErrorPassword.ForeColor = System.Drawing.Color.Red;
            this.lblErrorPassword.Location = new System.Drawing.Point(180, 119);
            this.lblErrorPassword.Name = "lblErrorPassword";
            this.lblErrorPassword.Size = new System.Drawing.Size(170, 16);
            this.lblErrorPassword.TabIndex = 19;
            this.lblErrorPassword.Text = "Introduce la contraseña";
            this.lblErrorPassword.Visible = false;
            // 
            // lblErrorRepeatPassword
            // 
            this.lblErrorRepeatPassword.AutoSize = true;
            this.lblErrorRepeatPassword.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblErrorRepeatPassword.ForeColor = System.Drawing.Color.Red;
            this.lblErrorRepeatPassword.Location = new System.Drawing.Point(180, 179);
            this.lblErrorRepeatPassword.Name = "lblErrorRepeatPassword";
            this.lblErrorRepeatPassword.Size = new System.Drawing.Size(152, 16);
            this.lblErrorRepeatPassword.TabIndex = 20;
            this.lblErrorRepeatPassword.Text = "Repite la contraseña";
            this.lblErrorRepeatPassword.Visible = false;
            // 
            // lblErrorRol
            // 
            this.lblErrorRol.AutoSize = true;
            this.lblErrorRol.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblErrorRol.ForeColor = System.Drawing.Color.Red;
            this.lblErrorRol.Location = new System.Drawing.Point(180, 236);
            this.lblErrorRol.Name = "lblErrorRol";
            this.lblErrorRol.Size = new System.Drawing.Size(111, 16);
            this.lblErrorRol.TabIndex = 21;
            this.lblErrorRol.Text = "Introduce el rol";
            this.lblErrorRol.Visible = false;
            // 
            // lblErrorPassworRepetidas
            // 
            this.lblErrorPassworRepetidas.AutoSize = true;
            this.lblErrorPassworRepetidas.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblErrorPassworRepetidas.ForeColor = System.Drawing.Color.Red;
            this.lblErrorPassworRepetidas.Location = new System.Drawing.Point(141, 179);
            this.lblErrorPassworRepetidas.Name = "lblErrorPassworRepetidas";
            this.lblErrorPassworRepetidas.Size = new System.Drawing.Size(227, 16);
            this.lblErrorPassworRepetidas.TabIndex = 22;
            this.lblErrorPassworRepetidas.Text = "Las contraseñas no son iguales";
            this.lblErrorPassworRepetidas.Visible = false;
            // 
            // AddUserView
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(398, 326);
            this.Controls.Add(this.lblErrorPassworRepetidas);
            this.Controls.Add(this.lblErrorRol);
            this.Controls.Add(this.lblErrorRepeatPassword);
            this.Controls.Add(this.lblErrorPassword);
            this.Controls.Add(this.lblErrorUserName);
            this.Controls.Add(this.btnAdd);
            this.Controls.Add(this.cmbRol);
            this.Controls.Add(this.txbRepeatPassword);
            this.Controls.Add(this.txbPassword);
            this.Controls.Add(this.txbUserName);
            this.Controls.Add(this.lblRol);
            this.Controls.Add(this.lblRepeatPassword);
            this.Controls.Add(this.lblPassword);
            this.Controls.Add(this.lblUserName);
            this.Name = "AddUserView";
            this.Text = "Add a new user";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblUserName;
        private System.Windows.Forms.Label lblPassword;
        private System.Windows.Forms.Label lblRepeatPassword;
        private System.Windows.Forms.Label lblRol;
        private System.Windows.Forms.TextBox txbUserName;
        private System.Windows.Forms.TextBox txbPassword;
        private System.Windows.Forms.TextBox txbRepeatPassword;
        private System.Windows.Forms.ComboBox cmbRol;
        private System.Windows.Forms.Button btnAdd;
        private System.Windows.Forms.Label lblErrorUserName;
        private System.Windows.Forms.Label lblErrorPassword;
        private System.Windows.Forms.Label lblErrorRepeatPassword;
        private System.Windows.Forms.Label lblErrorRol;
        private System.Windows.Forms.Label lblErrorPassworRepetidas;
    }
}