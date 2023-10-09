<!DOCTYPE html>
<html>

<head>
    <title>Page Title</title>
</head>

<body>

    <?php
    require_once($_SERVER['DOCUMENT_ROOT'] . "/WebProjectTU/database/index.php");
    require_once($_SERVER['DOCUMENT_ROOT'] . "/WebProjectTU/services/position.service.php");

    $position_service = new PositionService($pdo);

    $positions = $position_service->all();
    echo "
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>";

    foreach ($positions as $position) {
        echo "<tr>";
        $current_id = 0;

        foreach ($position as $key => $value) {
            echo "<td>$value</td>";

            if ($key === "id") {
                $current_id = $value;
            }
        }

        echo "<td><a href=/test>Edit</a>";
        echo "<form method=post>
                <input type=hidden name=id value=$current_id>
                <input type=submit name=delete value=Delete>
            </form>
            </td></tr>";
    }

    echo "</table>";

    if (isset($_POST["delete"])) {
        $current_position_id = $_POST["id"];
        $position_service->delete($current_position_id);
    }
    ?>

</body>

</html>