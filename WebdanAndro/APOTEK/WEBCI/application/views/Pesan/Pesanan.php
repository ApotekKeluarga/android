<?php $this->load->view('Home/js'); ?>
<?php $this->load->view('Home/Navbar'); ?>
<?php $this->load->view('Home/Sidebar'); ?>
</div>
 <!-- Page -->
  <div class="page">
    <div class="page-header">
      <h1 class="page-title">Data Pesanan</h1>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="http://localhost/WeBb/WEBCI/index.php/Web/Dashboard">Dashboard</a></li>
        <li class="breadcrumb-item active">Data Pesanan</li>
      </ol>
    </div>

    <?php $this->load->view('Search'); ?>
      <!-- Panel Table Add Row -->
      <div class="panel">
        <div class="panel-body">
          <div class="row">
            <div class="col-md-6">
              <div class="mb-15">
              </div>
            </div>
          
        <table class="table table-bordered" width="100%" cellspacing="0">
          <thead class="bg-light">
            
            <tr>
              <th>Kode pesan</th>
              <th>Kode User</th>
              <th>Nama User</th>
              <th>No. Telp </th>
              <th>Tanggal Order</th>
              <th>Alamat</th>
              <th>Metode Pengiriman</th>
              <th>Metode Pembayaran</th>
              <th>status</th>
              <th width="115px">Action</th>
            </tr>
            
        </thead>
            <tbody>
              <?php
            foreach ($data_pesanan as $row) {
            ?>
            <tr>
              <th><?php echo $row -> kd_order ?></th>
              <th><?php echo $row -> kd_user ?></th>
              <th><?php echo $row -> nama ?></th>
              <th><?php echo $row -> No_telp ?></th>
              <th><?php echo $row -> Tgl_order ?></th>
              <th><?php echo $row -> Detail_alamat ?></th>
              <th><?php echo $row -> mtd_pengirman ?></th>
              <th><?php echo $row -> mtd_pembayaran ?></th>
              <th><?php echo $row -> status ?></th>
              <th><a href="<?php echo base_url('index.php/Pesanan/detailPesanan/'.$row -> kd_order) ?>"><i class="icon md-eye" aria-hidden="true"></i> </a>
              </th>
            </tr>
            <?php } ?>
              
            </tbody>
          </table>
        </div>
      </div>
      <!-- End Panel Table Add Row -->   

    </div>
  </div>
  <!-- End Page -->

<?php $this->load->view('Home/Footer'); ?>