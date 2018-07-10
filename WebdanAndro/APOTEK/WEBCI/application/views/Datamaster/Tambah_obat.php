<?php $this->load->view('Home/js'); ?>
<?php $this->load->view('Home/Navbar'); ?>
<?php $this->load->view('Home/Sidebar'); ?>
</div>
 <!-- Page -->
  <div class="page">
    <div class="page-header">
      <h1 class="page-title">Tambah Obat</h1>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="http://localhost/WeBb/WEBCI/index.php/Web/Dashboard">Dashboard</a></li>
        <li class="breadcrumb-item"><a href="http://localhost/WeBb/WEBCI/index.php/Data_obat">Data Obat</a></li>
        <li class="breadcrumb-item active">Tambah Obat</li>
      </ol>
    </div>

    <!-- awal page content -->
    <div class="page-content">
      <div class="panel">
            <div class="panel-heading">
              <h3 class="panel-title">Tambah Obat</h3>
            </div>
            <div class="card-body">
              <form autocomplete="off" method="post" action="<?php echo base_url(). 'index.php/Data_obat/create'; ?>" enctype="multipart/form-data">
                <div class="col-md-10 ">
                    <h4 class="example-title">Nama Obat</h4>
                    <input type="text" class="form-control" id="inputPlaceholder" placeholder="Masukkan Nama Obat" name="nm_barang">
                    <input type="hidden" class="form-control" name="id" placeholder="Masukkan Judul Obat">
                </div>
                <div class="col-md-6 ">
                   <h4 class="example-title">Kategori Obat</h4>
                  <select class="form-control" name="kd_kategori">
                    <option>--- Pilih Kategori ---</option>
                    <?php
                      foreach ($data_kategori as $value) {
                    ?>
                    <option value="<?php echo $value->kd_kategori ?>"><?php echo $value->nm_kategori; ?></option>
                    <?php
                      }
                    ?>
                  </select>
                </div>
                <div class="col-md-10 ">
                    <h4 class="example-title">Komposisi</h4>
                    <textarea class="form-control" id="textareaDefault" rows="3" placeholder="Masukkan Komposisi Obat" name="komposisi"></textarea>
                </div>
                <div class="col-md-10 ">
                    <h4 class="example-title">Indikasi</h4>
                    <input type="text" class="form-control" id="inputPlaceholder" placeholder="Masukkan Indikasi" name="indikasi">
                </div>
                <div class="col-md-10 ">
                    <h4 class="example-title">Dosis</h4>
                    <input type="text" class="form-control" name="dosis" id="inputPlaceholder" placeholder="Masukkan Dosis">
                </div>
                <div class="col-md-10 ">
                    <h4 class="example-title">Penyajian</h4>
                    <textarea class="form-control" id="textareaDefault" rows="3" name="penyajian" placeholder="Masukkan Penyajian"></textarea>
              </div>
                <div class="col-md-10 ">
                    <h4 class="example-title">Kemasan</h4>
                    <input type="text" class="form-control" name="kemasan" id="inputPlaceholder" placeholder="Masukkan Jenis Kemasan">
                </div>
                <div class="col-md-10 ">
                    <h4 class="example-title">Harga</h4>
                    <input type="text" class="form-control" name="harga" id="inputPlaceholder" placeholder="Masukkan Harga">
                </div>
                <div class="col-md-10 ">
                    <h4 class="example-title">Deskripsi</h4>
                    <textarea class="form-control" id="textareaDefault" name="deskripsi" rows="3" placeholder="Masukkan Deskripsi"></textarea>
                </div>
                <div class="col-md-10 ">
                    <h4 class="example-title">Stok</h4>
                    <input type="text" class="form-control" id="inputPlaceholder" name="stok" placeholder="Masukkan Jumlah Stok">
                </div>
              <div class="col-md-6 col-lg-4">
                <h4 class="example-title">Masukkan Gambar</h4>
                <div class="example">
                  <input type="file" id="input-file-events" class="dropify-event" data-default-file="../../global/photos/view-6-960x640.jpg" name="img" accept="images/*">
                </div>
              
                <div class="form-group form-material floating" data-plugin="formMaterial">
                  <div class="input-group">
                    <span class="input-group-btn">
                      <button class="btn btn-info" type="submit" name="btnSubmit">Simpan</button>
                    </span>
                  </div>
                </div>
                </div>
              </form>
            </div>
          </div>
    </div>
    <!-- akhir page content -->
  </div>
  <!-- End Page -->

<?php $this->load->view('Home/Footer'); ?>