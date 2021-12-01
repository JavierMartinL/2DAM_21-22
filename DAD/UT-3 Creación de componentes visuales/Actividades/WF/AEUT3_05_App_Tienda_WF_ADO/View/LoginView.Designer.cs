
namespace View
{
    partial class LoginVIew
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.lblStaff = new System.Windows.Forms.Label();
            this.txbStaff = new System.Windows.Forms.TextBox();
            this.txbPassword = new System.Windows.Forms.TextBox();
            this.lblPassword = new System.Windows.Forms.Label();
            this.btnLogin = new System.Windows.Forms.Button();
            this.lblErrorStaff = new System.Windows.Forms.Label();
            this.lblErrorPassword = new System.Windows.Forms.Label();
            this.lblError = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // lblStaff
            // 
            this.lblStaff.AutoSize = true;
            this.lblStaff.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblStaff.Location = new System.Drawing.Point(49, 39);
            this.lblStaff.Name = "lblStaff";
            this.lblStaff.Size = new System.Drawing.Size(115, 24);
            this.lblStaff.TabIndex = 0;
            this.lblStaff.Text = "Number staff";
            // 
            // txbStaff
            // 
            this.txbStaff.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txbStaff.Location = new System.Drawing.Point(181, 34);
            this.txbStaff.Name = "txbStaff";
            this.txbStaff.Size = new System.Drawing.Size(214, 29);
            this.txbStaff.TabIndex = 1;
            this.txbStaff.KeyDown += new System.Windows.Forms.KeyEventHandler(this.loginkey);
            // 
            // txbPassword
            // 
            this.txbPassword.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txbPassword.Location = new System.Drawing.Point(181, 86);
            this.txbPassword.Name = "txbPassword";
            this.txbPassword.PasswordChar = '*';
            this.txbPassword.Size = new System.Drawing.Size(214, 29);
            this.txbPassword.TabIndex = 3;
            this.txbPassword.KeyDown += new System.Windows.Forms.KeyEventHandler(this.loginkey);
            // 
            // lblPassword
            // 
            this.lblPassword.AutoSize = true;
            this.lblPassword.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblPassword.Location = new System.Drawing.Point(49, 91);
            this.lblPassword.Name = "lblPassword";
            this.lblPassword.Size = new System.Drawing.Size(92, 24);
            this.lblPassword.TabIndex = 2;
            this.lblPassword.Text = "Password";
            // 
            // btnLogin
            // 
            this.btnLogin.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnLogin.Location = new System.Drawing.Point(457, 56);
            this.btnLogin.Name = "btnLogin";
            this.btnLogin.Size = new System.Drawing.Size(103, 32);
            this.btnLogin.TabIndex = 4;
            this.btnLogin.Text = "Submit";
            this.btnLogin.UseVisualStyleBackColor = true;
            this.btnLogin.Click += new System.EventHandler(this.login);
            this.btnLogin.KeyDown += new System.Windows.Forms.KeyEventHandler(this.loginkey);
            // 
            // lblErrorStaff
            // 
            this.lblErrorStaff.AutoSize = true;
            this.lblErrorStaff.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblErrorStaff.ForeColor = System.Drawing.Color.Red;
            this.lblErrorStaff.Location = new System.Drawing.Point(178, 66);
            this.lblErrorStaff.Name = "lblErrorStaff";
            this.lblErrorStaff.Size = new System.Drawing.Size(42, 16);
            this.lblErrorStaff.TabIndex = 5;
            this.lblErrorStaff.Text = "Error";
            this.lblErrorStaff.Visible = false;
            // 
            // lblErrorPassword
            // 
            this.lblErrorPassword.AutoSize = true;
            this.lblErrorPassword.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblErrorPassword.ForeColor = System.Drawing.Color.Red;
            this.lblErrorPassword.Location = new System.Drawing.Point(178, 118);
            this.lblErrorPassword.Name = "lblErrorPassword";
            this.lblErrorPassword.Size = new System.Drawing.Size(170, 16);
            this.lblErrorPassword.TabIndex = 6;
            this.lblErrorPassword.Text = "Introduce la contraseña";
            this.lblErrorPassword.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.lblErrorPassword.Visible = false;
            // 
            // lblError
            // 
            this.lblError.AutoSize = true;
            this.lblError.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblError.ForeColor = System.Drawing.Color.Red;
            this.lblError.Location = new System.Drawing.Point(178, 129);
            this.lblError.Name = "lblError";
            this.lblError.Size = new System.Drawing.Size(321, 16);
            this.lblError.TabIndex = 9;
            this.lblError.Text = "Las credenciales introducidas no son validas";
            this.lblError.Visible = false;
            // 
            // lblErrorStaff
            // 
            this.lblErrorStaff.AutoSize = true;
            this.lblErrorStaff.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblErrorStaff.ForeColor = System.Drawing.Color.Red;
            this.lblErrorStaff.Location = new System.Drawing.Point(178, 66);
            this.lblErrorStaff.Name = "lblErrorStaff";
            this.lblErrorStaff.Size = new System.Drawing.Size(42, 16);
            this.lblErrorStaff.TabIndex = 5;
            this.lblErrorStaff.Text = "Error";
            this.lblErrorStaff.Visible = false;
            // 
            // lblErrorPassword
            // 
            this.lblErrorPassword.AutoSize = true;
            this.lblErrorPassword.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblErrorPassword.ForeColor = System.Drawing.Color.Red;
            this.lblErrorPassword.Location = new System.Drawing.Point(178, 118);
            this.lblErrorPassword.Name = "lblErrorPassword";
            this.lblErrorPassword.Size = new System.Drawing.Size(170, 16);
            this.lblErrorPassword.TabIndex = 6;
            this.lblErrorPassword.Text = "Introduce la contraseña";
            this.lblErrorPassword.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.lblErrorPassword.Visible = false;
            // 
            // lblError
            // 
            this.lblError.AutoSize = true;
            this.lblError.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblError.ForeColor = System.Drawing.Color.Red;
            this.lblError.Location = new System.Drawing.Point(178, 129);
            this.lblError.Name = "lblError";
            this.lblError.Size = new System.Drawing.Size(321, 16);
            this.lblError.TabIndex = 9;
            this.lblError.Text = "Las credenciales introducidas no son validas";
            this.lblError.Visible = false;
            // 
            // LoginVIew
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.ClientSize = new System.Drawing.Size(599, 154);
            this.Controls.Add(this.lblError);
            this.Controls.Add(this.lblErrorPassword);
            this.Controls.Add(this.lblErrorStaff);
            this.Controls.Add(this.btnLogin);
            this.Controls.Add(this.txbPassword);
            this.Controls.Add(this.lblPassword);
            this.Controls.Add(this.txbStaff);
            this.Controls.Add(this.lblStaff);
            this.KeyPreview = true;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "LoginVIew";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Login";
            this.Enter += new System.EventHandler(this.login);
            this.KeyDown += new System.Windows.Forms.KeyEventHandler(this.loginkey);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblStaff;
        private System.Windows.Forms.TextBox txbStaff;
        private System.Windows.Forms.TextBox txbPassword;
        private System.Windows.Forms.Label lblPassword;
        private System.Windows.Forms.Button btnLogin;
        private System.Windows.Forms.Label lblErrorStaff;
        private System.Windows.Forms.Label lblErrorPassword;
        private System.Windows.Forms.Label lblError;
    }
}

