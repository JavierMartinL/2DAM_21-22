
namespace View
{
    partial class PrincipalView
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
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.tsmiStudent = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiAdd = new System.Windows.Forms.ToolStripMenuItem();
            this.listToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiDelete = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiGamificationManager = new System.Windows.Forms.ToolStripMenuItem();
            this.searchToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiUsersManager = new System.Windows.Forms.ToolStripMenuItem();
            this.listAllToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.addUserToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.deleteAUserToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.modifyAUserToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tsUserManager = new System.Windows.Forms.ToolStrip();
            this.toolStripButton1 = new System.Windows.Forms.ToolStripButton();
            this.toolStripButton2 = new System.Windows.Forms.ToolStripButton();
            this.toolStripButton3 = new System.Windows.Forms.ToolStripButton();
            this.toolStripButton4 = new System.Windows.Forms.ToolStripButton();
            this.menuStrip1.SuspendLayout();
            this.tsUserManager.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmiStudent,
            this.tsmiGamificationManager,
            this.tsmiUsersManager});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(800, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // tsmiStudent
            // 
            this.tsmiStudent.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmiAdd,
            this.listToolStripMenuItem,
            this.tsmiDelete});
            this.tsmiStudent.Name = "tsmiStudent";
            this.tsmiStudent.Size = new System.Drawing.Size(113, 20);
            this.tsmiStudent.Text = " Student Manager";
            // 
            // tsmiAdd
            // 
            this.tsmiAdd.Name = "tsmiAdd";
            this.tsmiAdd.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.A)));
            this.tsmiAdd.Size = new System.Drawing.Size(149, 22);
            this.tsmiAdd.Text = "Add";
            // 
            // listToolStripMenuItem
            // 
            this.listToolStripMenuItem.Name = "listToolStripMenuItem";
            this.listToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.L)));
            this.listToolStripMenuItem.Size = new System.Drawing.Size(149, 22);
            this.listToolStripMenuItem.Text = "List";
            // 
            // tsmiDelete
            // 
            this.tsmiDelete.Name = "tsmiDelete";
            this.tsmiDelete.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.D)));
            this.tsmiDelete.Size = new System.Drawing.Size(149, 22);
            this.tsmiDelete.Text = "Delete";
            // 
            // tsmiGamificationManager
            // 
            this.tsmiGamificationManager.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.searchToolStripMenuItem});
            this.tsmiGamificationManager.Name = "tsmiGamificationManager";
            this.tsmiGamificationManager.Size = new System.Drawing.Size(137, 20);
            this.tsmiGamificationManager.Text = "Gamification manager";
            // 
            // searchToolStripMenuItem
            // 
            this.searchToolStripMenuItem.Name = "searchToolStripMenuItem";
            this.searchToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.S)));
            this.searchToolStripMenuItem.Size = new System.Drawing.Size(149, 22);
            this.searchToolStripMenuItem.Text = "Search";
            // 
            // tsmiUsersManager
            // 
            this.tsmiUsersManager.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.listAllToolStripMenuItem,
            this.addUserToolStripMenuItem,
            this.deleteAUserToolStripMenuItem,
            this.modifyAUserToolStripMenuItem});
            this.tsmiUsersManager.Name = "tsmiUsersManager";
            this.tsmiUsersManager.Size = new System.Drawing.Size(97, 20);
            this.tsmiUsersManager.Text = "Users manager";
            // 
            // listAllToolStripMenuItem
            // 
            this.listAllToolStripMenuItem.Name = "listAllToolStripMenuItem";
            this.listAllToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.listAllToolStripMenuItem.Text = "List all";
            this.listAllToolStripMenuItem.Click += new System.EventHandler(this.listAll);
            // 
            // addUserToolStripMenuItem
            // 
            this.addUserToolStripMenuItem.Name = "addUserToolStripMenuItem";
            this.addUserToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.addUserToolStripMenuItem.Text = "Add a user";
            this.addUserToolStripMenuItem.Click += new System.EventHandler(this.crearUsuario);
            // 
            // deleteAUserToolStripMenuItem
            // 
            this.deleteAUserToolStripMenuItem.Name = "deleteAUserToolStripMenuItem";
            this.deleteAUserToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.deleteAUserToolStripMenuItem.Text = "Delete a user";
            // 
            // modifyAUserToolStripMenuItem
            // 
            this.modifyAUserToolStripMenuItem.Name = "modifyAUserToolStripMenuItem";
            this.modifyAUserToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.modifyAUserToolStripMenuItem.Text = "Modify a user";
            // 
            // tsUserManager
            // 
            this.tsUserManager.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripButton1,
            this.toolStripButton2,
            this.toolStripButton3,
            this.toolStripButton4});
            this.tsUserManager.Location = new System.Drawing.Point(0, 24);
            this.tsUserManager.Name = "tsUserManager";
            this.tsUserManager.Size = new System.Drawing.Size(800, 39);
            this.tsUserManager.TabIndex = 1;
            this.tsUserManager.Text = "toolStrip1";
            // 
            // toolStripButton1
            // 
            this.toolStripButton1.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripButton1.Image = global::View.Properties.Resources.list;
            this.toolStripButton1.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.toolStripButton1.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButton1.Name = "toolStripButton1";
            this.toolStripButton1.Size = new System.Drawing.Size(36, 36);
            this.toolStripButton1.Text = "toolStripButton1";
            this.toolStripButton1.Click += new System.EventHandler(this.listAll);
            // 
            // toolStripButton2
            // 
            this.toolStripButton2.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripButton2.Image = global::View.Properties.Resources.add;
            this.toolStripButton2.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.toolStripButton2.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButton2.Name = "toolStripButton2";
            this.toolStripButton2.Size = new System.Drawing.Size(36, 36);
            this.toolStripButton2.Text = "toolStripButton2";
            this.toolStripButton2.Click += new System.EventHandler(this.crearUsuario);
            // 
            // toolStripButton3
            // 
            this.toolStripButton3.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripButton3.Image = global::View.Properties.Resources.delete;
            this.toolStripButton3.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.toolStripButton3.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButton3.Name = "toolStripButton3";
            this.toolStripButton3.Size = new System.Drawing.Size(36, 36);
            this.toolStripButton3.Text = "toolStripButton3";
            // 
            // toolStripButton4
            // 
            this.toolStripButton4.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripButton4.Image = global::View.Properties.Resources.update;
            this.toolStripButton4.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.toolStripButton4.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButton4.Name = "toolStripButton4";
            this.toolStripButton4.Size = new System.Drawing.Size(36, 36);
            this.toolStripButton4.Text = "toolStripButton4";
            // 
            // PrincipalView
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.tsUserManager);
            this.Controls.Add(this.menuStrip1);
            this.IsMdiContainer = true;
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "PrincipalView";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Gamification app";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.tsUserManager.ResumeLayout(false);
            this.tsUserManager.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem tsmiStudent;
        private System.Windows.Forms.ToolStripMenuItem tsmiAdd;
        private System.Windows.Forms.ToolStripMenuItem listToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem tsmiDelete;
        private System.Windows.Forms.ToolStrip tsUserManager;
        private System.Windows.Forms.ToolStripButton toolStripButton1;
        private System.Windows.Forms.ToolStripButton toolStripButton2;
        private System.Windows.Forms.ToolStripButton toolStripButton3;
        private System.Windows.Forms.ToolStripButton toolStripButton4;
        private System.Windows.Forms.ToolStripMenuItem tsmiGamificationManager;
        private System.Windows.Forms.ToolStripMenuItem searchToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem tsmiUsersManager;
        private System.Windows.Forms.ToolStripMenuItem listAllToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem addUserToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem deleteAUserToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem modifyAUserToolStripMenuItem;
    }
}