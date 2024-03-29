<?php
require_once($_SERVER['DOCUMENT_ROOT'] . "/WebProjectTU/database/index.php");
require_once($_SERVER['DOCUMENT_ROOT'] . "/WebProjectTU/services/author.service.php");

$author_service = new AuthorService($pdo);

$resource_name = "Author";
$collection = $author_service->all();
$table_header = "
    <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Actions</th>";

include($_SERVER['DOCUMENT_ROOT'] . "/WebProjectTU/views/templates/table.php");

if (isset($_POST["delete"])) {
    $current_author_id = $_POST["id"];
    $author_service->delete($current_author_id);

}
?>