using UnityEngine;

public class Bullet : MonoBehaviour
{
    [SerializeField] float speed = 20f;
    [SerializeField] float lifeTime = 2f;
    [SerializeField] int damage = 1;

    private void Start()
    {
        Destroy(gameObject, lifeTime);
    }

    private void Update()
    {
        transform.Translate(Vector3.forward * speed * Time.deltaTime);
    }

    private void OnTriggerEnter(Collider other)
    {
        if (other.CompareTag("Target"))
        {
            Target target = other.GetComponent<Target>();
            if (target != null)
                target.TakeDamage(damage);

            Destroy(gameObject);
        }
    }
}