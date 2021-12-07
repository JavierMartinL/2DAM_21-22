
namespace View
{
    partial class ProductoDetail
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
            this.ctlProductDetail = new ctlProductDetailLib.ctlProductDetail();
            this.SuspendLayout();
            // 
            // ctlProductDetail
            // 
            this.ctlProductDetail.Cantidad = "value";
            this.ctlProductDetail.Categoria = "value";
            this.ctlProductDetail.Id = "value";
            this.ctlProductDetail.Location = new System.Drawing.Point(3, -1);
            this.ctlProductDetail.Name = "ctlProductDetail";
            this.ctlProductDetail.Nombre = "value";
            this.ctlProductDetail.Size = new System.Drawing.Size(172, 111);
            this.ctlProductDetail.TabIndex = 0;
            // 
            // ProductoDetail
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.ClientSize = new System.Drawing.Size(214, 110);
            this.Controls.Add(this.ctlProductDetail);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "ProductoDetail";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Product Detail";
            this.ResumeLayout(false);

        }

        #endregion

        private ctlProductDetailLib.ctlProductDetail ctlProductDetail;
    }
}